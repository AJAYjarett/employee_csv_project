package employee_csv_project.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private static final Properties config;

    static {
        config = new Properties();

        try {
            config.load(new BufferedReader(new FileReader("src/main/resources/config.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String employeeCsvFileLocation(){
        return config.getProperty("employee_csv_file_location");
    }
}
