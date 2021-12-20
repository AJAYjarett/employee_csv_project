package employee_csv_project.model;

import java.util.ArrayList;

public class EmployeesDAO {
    //stores employees

    ArrayList<EmployeeDTO> allEmployees = new ArrayList<>();

    //places all employees into and ArrayList
    public void addEmployeesToList(String[] listOfEmployeesAsString){
        for (int i = 0; i < listOfEmployeesAsString.length; i++) {
            EmployeeDTO employee = new EmployeeDTO(listOfEmployeesAsString);
            allEmployees.add(employee);
        }
    }

}
