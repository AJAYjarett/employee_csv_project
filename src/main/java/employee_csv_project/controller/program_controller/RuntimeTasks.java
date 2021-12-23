package employee_csv_project.controller.program_controller;

import employee_csv_project.config.Config;
import employee_csv_project.controller.csv_controller.csv_intake.EmployeeCsvParser;
import employee_csv_project.controller.csv_controller.data_validation.EmployeeCheck;
import employee_csv_project.controller.csv_controller.duplication_handler.CheckForDuplicates;
import employee_csv_project.controller.db_controller.send_data_to_database.CreateDbAndTable;
import employee_csv_project.controller.db_controller.send_data_to_database.SendEmployeeData;
import employee_csv_project.model.EmployeeDTO;
import employee_csv_project.controller.logger.LogWriter;
import employee_csv_project.model.EmployeesDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class RuntimeTasks {

    public static EmployeesDAO createEmployeesDAO() {
        EmployeesDAO employeesDAO = new EmployeesDAO();

        LogWriter.writeLog(Level.INFO, "Getting employee data from CSV file");
        List<String[]> employeesToStore = EmployeeCsvParser.createEmployeeData(Config.employeeCsvFileLocation());
        for (int i = 0; i < employeesToStore.size(); i++) {
            if (EmployeeCheck.checkEmployeeIsValid(employeesToStore.get(i))) {
                EmployeeDTO employeeDTO = new EmployeeDTO(employeesToStore.get(i));
                employeesDAO.addEmployeeToList(employeeDTO);
            }
//            System.out.println(Arrays.toString(employeesToStore.get(i)));

        }
        System.out.println(CheckForDuplicates.getListOfNonDuplicatedEmployees().size());
        System.out.println(CheckForDuplicates.getListOfDuplicatedEmployees().size());
        /*CheckForDuplicates.writeDuplicatesIntoFile("src/main/resources/EmployeeDuplicatesRecords.csv");*/
        return employeesDAO;
    }

    public static void createDbFromEmployeesDAO(EmployeesDAO employeesDAO) {
        ArrayList<EmployeeDTO> allEmployees = employeesDAO.getAllEmployees();

        CreateDbAndTable.initialiseDatabaseAndTable();
        for (int i = 0; i < allEmployees.size(); i++) {
            SendEmployeeData.sendEmployeeToDb(allEmployees.get(i));

        }
    }

}
