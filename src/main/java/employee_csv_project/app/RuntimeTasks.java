package employee_csv_project.app;

import employee_csv_project.controller.EmployeeCsvParser;
import employee_csv_project.model.EmployeesDAO;

import java.util.Arrays;
import java.util.List;

public class RuntimeTasks {

    public static EmployeesDAO createEmployeesDAO(){
        EmployeesDAO employeesDAO = new EmployeesDAO();
        List<String[]> employeesToStore = EmployeeCsvParser.createEmployeeData();
        for (int i = 0; i < employeesToStore.size(); i++) {
            employeesDAO.addEmployeeToList(employeesToStore.get(i));
            System.out.println(Arrays.toString(employeesToStore.get(i)));
        }
        return employeesDAO;
    }

    public static void createDbFromEmployeesDAO(EmployeesDAO employeesDAO){

    }
}
