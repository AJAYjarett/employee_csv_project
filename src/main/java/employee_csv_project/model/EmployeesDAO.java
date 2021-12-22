package employee_csv_project.model;

import employee_csv_project.controller.csv_controller.duplication_check.CheckForDuplicates;

import java.util.ArrayList;

public class EmployeesDAO {
    //stores employees

    ArrayList<EmployeeDTO> allEmployees = new ArrayList<>();

    //places all employees into and ArrayList
    public void addEmployeeToList(String[] employeeData){
        EmployeeDTO employee = new EmployeeDTO(employeeData);
        if(CheckForDuplicates.checkDuplicates(employee)) {
            allEmployees.add(employee);
        }
    }

    public ArrayList<EmployeeDTO> getAllEmployees() {
        return allEmployees;
    }
}
