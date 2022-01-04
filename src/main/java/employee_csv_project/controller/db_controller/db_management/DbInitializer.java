package employee_csv_project.controller.db_controller.db_management;

import employee_csv_project.controller.db_controller.sql_queries.SQLPreparedQueries;

import java.sql.Connection;
import java.sql.SQLException;

public class DbInitializer {

    private static void initializeDb() {

        try {

            Connection connection = ConnectionManager.dbInitialiseConnection();
            connection.createStatement().executeUpdate(SQLPreparedQueries.DB_INITIALISE);
            ConnectionManager.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void initializeEmployeeTable() {

        try {
            Connection connection = ConnectionManager.dbEmployeeCSVDatabaseConnection();
            connection.createStatement().executeUpdate(SQLPreparedQueries.CREATE_EMPLOYEES_TABLE);
            ConnectionManager.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void initializeDbFirstInstance(){
        DbInitializer.initializeDb();
        DbInitializer.initializeEmployeeTable();
    }

}
