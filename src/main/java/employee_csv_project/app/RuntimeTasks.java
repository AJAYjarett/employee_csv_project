package employee_csv_project.app;

import employee_csv_project.controller.EmployeeCsvParser;
import employee_csv_project.logger.LogWriter;
import employee_csv_project.model.EmployeesDAO;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class RuntimeTasks {

    public static EmployeesDAO createEmployeesDAO(){
        EmployeesDAO employeesDAO = new EmployeesDAO();

        LogWriter.writeLog(Level.INFO, "Getting employee data from CSV file");
        List<String[]> employeesToStore = EmployeeCsvParser.createEmployeeData();
        for (int i = 0; i < employeesToStore.size(); i++) {
            employeesDAO.addEmployeeToList(employeesToStore.get(i));
//            System.out.println(Arrays.toString(employeesToStore.get(i)));
        }
        return employeesDAO;
    }

    public static void createDbFromEmployeesDAO(EmployeesDAO employeesDAO){

    }
}
