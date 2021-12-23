package employee_csv_project.controller.program_controller;

import employee_csv_project.controller.logger.LogWriter;

import java.util.logging.Level;
import employee_csv_project.model.EmployeesDAO;


public class RuntimeController {

    public static void runProgram(){
        LogWriter.createLogger();
        LogWriter.writeLog(Level.INFO, "Logging Started");
      
        EmployeesDAO employeesDAO = RuntimeTasks.createEmployeesDAO();
        RuntimeTasks.createDbFromEmployeesDAO(employeesDAO);
    }
}
