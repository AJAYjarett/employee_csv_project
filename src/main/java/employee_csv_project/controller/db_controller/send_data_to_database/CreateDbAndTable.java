package employee_csv_project.controller.db_controller.send_data_to_database;

import employee_csv_project.controller.db_controller.db_management.ConnectionManager;
import employee_csv_project.controller.db_controller.sql_queries.SQLPreparedQueries;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateDbAndTable {

    public static void initialiseDatabaseAndTable(){
        try {
            Connection connection = ConnectionManager.dbEmployeeCSVDatabaseConnection();
            connection.createStatement().executeUpdate(SQLPreparedQueries.DB_INITIALISE);
            connection.createStatement().executeUpdate(SQLPreparedQueries.CREATE_EMPLOYEES_TABLE);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
