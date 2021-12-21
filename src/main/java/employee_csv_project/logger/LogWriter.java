package employee_csv_project.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogWriter {

    public static void createLogger(){
        Logger logger = Logger.getLogger("myLogger");
        try {
            Handler fileHandler = new FileHandler("src/main/resources/myLog.log", true);
            logger.addHandler(fileHandler);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeLog(Level level, String message){
        Logger logger = Logger.getLogger("myLogger");

        logger.setLevel(Level.INFO);
        logger.log(level, message);
    }
}
