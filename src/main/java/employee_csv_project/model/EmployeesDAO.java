package employee_csv_project.model;

import java.util.ArrayList;

public class EmployeesDAO {
    //stores employees

    ArrayList<EmployeeDTO> allEmployees = new ArrayList<>();

    //places all employees into and ArrayList
    public void addEmployeeToList(String[] employeeData){
        EmployeeDTO employee = new EmployeeDTO(employeeData);
        allEmployees.add(employee);
    }


}
