package employee_csv_project.controller.db_management;

import employee_csv_project.config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public static Connection dbInitializeConnection(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(Config.dbConnectionUrl(), Config.dbUserName(), Config.dbPassword());
            System.out.println("Connected to db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection dbCompanyXConnection(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(Config.dbConnectionUrl() + "/" + Config.dbName(), Config.dbUserName(), Config.dbPassword());
            System.out.println("Connected to db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection){
        try {
            connection.close();
            //logger goes here
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
