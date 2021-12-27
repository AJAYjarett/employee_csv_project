package employee_csv_project.model;

import employee_csv_project.controller.csv_controller.duplication_handler.CheckForDuplicates;

import java.util.ArrayList;

public class EmployeesDAO {
    //stores employees

    private ArrayList<EmployeeDTO> allEmployees = new ArrayList<>();

    //places all employees into and ArrayList
    public void addEmployeeToList(EmployeeDTO employeeData){
        allEmployees.add(employeeData);
    }
    public ArrayList<EmployeeDTO> getAllEmployees() {
        return allEmployees;
    }

}
