package employee_csv_project.controller.db_management;

import employee_csv_project.config.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public static Connection dbInitialiseConnection(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(Config.dbConnectionUrl(),Config.dbUsername(), Config.dbPassword());
            //use logger for this
            System.out.println("connect to db");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
  
    public static Connection dbEmployeeCSVDatabaseConnection(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(Config.dbConnectionUrl() + "/"+ Config.dbName(),Config.dbUsername(), Config.dbPassword());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection){
        try {
            connection.close();
            //use logger here
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
