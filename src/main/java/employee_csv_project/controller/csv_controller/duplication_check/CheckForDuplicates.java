package employee_csv_project.controller.csv_controller.duplication_check;

import employee_csv_project.controller.logger.LogWriter;
import employee_csv_project.model.EmployeeDTO;

import java.util.ArrayList;
import java.util.logging.Level;

public class CheckForDuplicates {
    private static ArrayList<EmployeeDTO> listOfNonDuplicatedEmployees = new ArrayList<>();
    private static ArrayList<EmployeeDTO> listOfDuplicatedEmployees = new ArrayList<>();

    public static boolean checkDuplicates(EmployeeDTO employee) {
        if (listOfNonDuplicatedEmployees.isEmpty()) {
            listOfNonDuplicatedEmployees.add(employee);
        } else {
            return !checkForIdDuplicates(employee);
        }
        return true;
    }

    public static boolean checkForIdDuplicates(EmployeeDTO employee) {
        for (EmployeeDTO listOfNonDuplicatedEmployee : listOfNonDuplicatedEmployees) {
            if (employee.getEmployeeId() == listOfNonDuplicatedEmployee.getEmployeeId()) {
                listOfDuplicatedEmployees.add(employee);
                String firstEmployee = listOfNonDuplicatedEmployee.getEmployeeId() + " " + listOfNonDuplicatedEmployee.getFirstName() +
                        " " + listOfNonDuplicatedEmployee.getLastName();
                String secondEmployee = employee.getEmployeeId() + " " + employee.getFirstName() + " " + employee.getLastName();
                LogWriter.writeLog(Level.INFO, "Duplicate found:\n" + firstEmployee + "\n" + secondEmployee);
                return false;

            }
        }
        return true;
    }

    public ArrayList<EmployeeDTO> getListOfNonDuplicatedEmployees() {
        return listOfNonDuplicatedEmployees;
    }

    public ArrayList<EmployeeDTO> getListOfDuplicatedEmployees() {
        return listOfDuplicatedEmployees;
    }
}
