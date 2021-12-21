package employee_csv_project.model;

import employee_csv_project.controller.db_management.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeesDAO {
    //stores employees

    ArrayList<EmployeeDTO> allEmployees = new ArrayList<>();

    //places all employees into and ArrayList
    public void addEmployeeToList(String[] employeeData){
        EmployeeDTO employee = new EmployeeDTO(employeeData);
        allEmployees.add(employee);
    }

    public ArrayList<EmployeeDTO> getAllEmployees() {
        return allEmployees;
    }
}
