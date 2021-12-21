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

    public static void addEmployeesToDatabase(){
        try {
            for (int i = 0; i < allEmployees.size(); i++) {
                Connection connection = ConnectionManager.dbEmployeeCSVDatabaseConnection();
                connection.createStatement().execute(QueryManager.createInsertQuery(allEmployees[i]));
                ConnectionManager.closeConnection(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
