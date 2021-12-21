package employee_csv_project.app;

import employee_csv_project.logger.LogWriter;

import java.util.logging.Level;

public class RuntimeController {

    public static void runProgram(){
        LogWriter.createLogger();
        LogWriter.writeLog(Level.INFO, "Logging Started");

        RuntimeTasks.createEmployeesDAO();
    }
}
