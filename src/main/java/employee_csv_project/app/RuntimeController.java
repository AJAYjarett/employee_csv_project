package employee_csv_project.app;

import employee_csv_project.model.EmployeesDAO;

public class RuntimeController {

    public static void runProgram(){
        EmployeesDAO employeesDAO = RuntimeTasks.createEmployeesDAO();
        RuntimeTasks.createDbFromEmployeesDAO(employeesDAO);
    }
}
