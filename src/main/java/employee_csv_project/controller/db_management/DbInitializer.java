package employee_csv_project.controller.db_management;

import employee_csv_project.controller.db_management.sql_queries.DbInitializeStatement;

import java.sql.Connection;
import java.sql.SQLException;

public class DbInitializer {

    private static void initializeDb() {

        try {
            Connection connection = ConnectionManager.dbInitializeConnection();
            connection.createStatement().executeUpdate(DbInitializeStatement.DB_INITIALISE);
            ConnectionManager.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void initializeEmployeeTable() {

        try {
            Connection connection = ConnectionManager.dbCompanyXConnection();
            connection.createStatement().executeUpdate(DbInitializeStatement.CREATE_EMPLOYEES_TABLE);
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
