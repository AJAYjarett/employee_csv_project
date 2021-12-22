package employee_csv_project.controller.db_controller.send_data_to_database;

import employee_csv_project.controller.db_controller.db_management.ConnectionManager;
import employee_csv_project.controller.db_controller.sql_queries.SQLPreparedQueries;
import employee_csv_project.model.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SendEmployeeData {

    public static void sendEmployeeToDb(EmployeeDTO employeeDTO){
        try {
            Connection connection = ConnectionManager.dbEmployeeCSVDatabaseConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(SQLPreparedQueries.INSERT_EMPLOYEE);
            preparedStatement.setInt(1,employeeDTO.getEmployeeId());
            preparedStatement.setString(2,employeeDTO.getNamePrefix());
            preparedStatement.setString(3,employeeDTO.getFirstName());
            preparedStatement.setString(4,employeeDTO.getMiddleInit());
            preparedStatement.setString(5,employeeDTO.getLastName());
            preparedStatement.setString(6,employeeDTO.getGender());
            preparedStatement.setString(7,employeeDTO.getEmail());
            preparedStatement.setString(8,employeeDTO.getDob());
            preparedStatement.setString(9,employeeDTO.getDateOfJoining());
            preparedStatement.setInt(10,employeeDTO.getSalary());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
