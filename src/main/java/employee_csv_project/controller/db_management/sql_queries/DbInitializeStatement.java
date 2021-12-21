package employee_csv_project.controller.db_management.sql_queries;


import employee_csv_project.config.Config;

public interface DbInitializeStatement {
    String DB_INITIALISE = "CREATE DATABASE IF NOT EXISTS " + Config.dbName();
    String CREATE_EMPLOYEES_TABLE = "CREATE TABLE IF NOT EXISTS employees (" +
            "employeeID INTEGER," +
            "name_prefix VARCHAR(4)," +
            "first_name VARCHAR(20)," +
            "middle_initial CHAR," +
            "last_name VARCHAR(20)," +
            "gender CHAR," +
            "e_mail VARCHAR(50)," +
            "date_of_birth VARCHAR(10)," +
            "date_of_joining VARCHAR(10)," +
            "salary INTEGER," +
            "PRIMARY KEY (employeeID))";


}
