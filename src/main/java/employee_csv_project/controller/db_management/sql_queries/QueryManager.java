package employee_csv_project.controller.db_management.sql_queries;

import employee_csv_project.model.EmployeeDTO;

public class QueryManager implements DbInitializeStatement{

    public static String createInsertQuery(EmployeeDTO employeeToInsert) {
        return "INSERT INTO employees VALUES (" +
                employeeToInsert.getEmployeeId() + ", " +
                employeeToInsert.getNamePrefix() + "," +
                employeeToInsert.getFirstName() + ", " +
                employeeToInsert.getMiddleInit() + ", " +
                employeeToInsert.getLastName() + ", " +
                employeeToInsert.getGender() + ", " +
                employeeToInsert.geteMail() + ", " +
                employeeToInsert.getDob() + ", " +
                employeeToInsert.getDateOfJoining() + ", " +
                employeeToInsert.getSalary() + ");";
    }
}
