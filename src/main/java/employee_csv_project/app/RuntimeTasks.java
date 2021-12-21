package employee_csv_project.app;

import employee_csv_project.controller.EmployeeCsvParser;
import employee_csv_project.controller.db_management.ConnectionManager;
import employee_csv_project.controller.db_management.sql_queries.QueryManager;
import employee_csv_project.controller.db_management.sql_queries.SQLPreparedQueries;
import employee_csv_project.model.EmployeeDTO;
import employee_csv_project.logger.LogWriter;
import employee_csv_project.model.EmployeesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class RuntimeTasks {

    public static EmployeesDAO createEmployeesDAO(){
        EmployeesDAO employeesDAO = new EmployeesDAO();

        LogWriter.writeLog(Level.INFO, "Getting employee data from CSV file");
        List<String[]> employeesToStore = EmployeeCsvParser.createEmployeeData();
        for (int i = 0; i < employeesToStore.size(); i++) {
            employeesDAO.addEmployeeToList(employeesToStore.get(i));
//            System.out.println(Arrays.toString(employeesToStore.get(i)));
        }
        return employeesDAO;
    }

    public static void createDbFromEmployeesDAO(EmployeesDAO employeesDAO){
        ArrayList<EmployeeDTO> allEmployees = employeesDAO.getAllEmployees();
        try {
            Connection connection = ConnectionManager.dbEmployeeCSVDatabaseConnection();
            connection.createStatement().executeUpdate(SQLPreparedQueries.DB_INITIALISE);
            connection.createStatement().executeUpdate(SQLPreparedQueries.CREATE_EMPLOYEES_TABLE);
            for (int i = 0; i < allEmployees.size(); i++) {
                PreparedStatement preparedStatement =connection.prepareStatement(SQLPreparedQueries.INSERT_EMPLOYEE);
                preparedStatement.setInt(1,allEmployees.get(i).getEmployeeId());
                preparedStatement.setString(2,allEmployees.get(i).getNamePrefix());
                preparedStatement.setString(3,allEmployees.get(i).getFirstName());
                preparedStatement.setString(4,allEmployees.get(i).getMiddleInit());
                preparedStatement.setString(5,allEmployees.get(i).getLastName());
                preparedStatement.setString(6,allEmployees.get(i).getGender());
                preparedStatement.setString(7,allEmployees.get(i).geteMail());
                preparedStatement.setString(8,allEmployees.get(i).getDob());
                preparedStatement.setString(9,allEmployees.get(i).getDateOfJoining());
                preparedStatement.setInt(10,allEmployees.get(i).getSalary());
                preparedStatement.execute();
            }
            ConnectionManager.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
