package employee_csv_project.controller.db_management.sql_queries;


import employee_csv_project.config.Config;

public interface SQLPreparedQueries {
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


    String DROP_TABLE_IF_EXISTS = "DROP TABLE IF EXISTS ?";

    String INSERT_EMPLOYEE = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?)";

    String DELETE_EMPLOYEE_BY_ID = "DELETE FROM employees WHERE employeeID=?";

    String DELETE_EMPLOYEE_BY_NAME = "DELETE FROM employees WHERE first_name=\"?\" AND last_name =\"?\"";

    String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employees WHERE employeeID=?";

}
