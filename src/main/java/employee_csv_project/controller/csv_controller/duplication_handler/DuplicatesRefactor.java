package employee_csv_project.controller.csv_controller.duplication_handler;

import employee_csv_project.controller.logger.LogWriter;
import employee_csv_project.model.EmployeeDTO;
import java.util.logging.Level;

public class DuplicatesRefactor {

    public static EmployeeDTO refactorEmployeeId(EmployeeDTO employee) {
        EmployeeDTO duplicatedEmployee = null;
        for (int i = 0; i < CheckForDuplicates.getListOfNonDuplicatedEmployees().size(); i++) {
            while (CheckForDuplicates.getListOfNonDuplicatedEmployees().get(i).getEmployeeId() == employee.getEmployeeId()) {
                duplicatedEmployee = employee;
                employee.setEmployeeId(employee.getEmployeeId() + 1);
            }
        }
        if (duplicatedEmployee != null) {
            String message = employee.getFirstName() + " " + employee.getLastName() + "id changed to: " + employee.getEmployeeId() + "\n";
            LogWriter.writeLog(Level.INFO, message);
        }
        return employee;
    }
}
