package employee_csv_project.model;

import employee_csv_project.controller.csv_controller.duplication_handler.CheckForDuplicates;
import employee_csv_project.controller.csv_controller.duplication_handler.DuplicatesRefactor;

import java.util.ArrayList;

public class EmployeesDAO {
    //stores employees

    ArrayList<EmployeeDTO> allEmployees = new ArrayList<>();

    //places all employees into and ArrayList
    public void addEmployeeToList(EmployeeDTO employeeData){

        if(CheckForDuplicates.checkDuplicates(employeeData)) {
            allEmployees.add(DuplicatesRefactor.refactorEmployeeId(employeeData));
        }
    }

    public ArrayList<EmployeeDTO> getAllEmployees() {
        return allEmployees;
    }
}
