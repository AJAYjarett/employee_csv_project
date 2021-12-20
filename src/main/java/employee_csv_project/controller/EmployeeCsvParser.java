package employee_csv_project.controller;

import employee_csv_project.config.Config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmployeeCsvParser {

    public static void createEmployeeData(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Config.employeeCsvFileLocation()));

            bufferedReader.readLine();
            for(String employeeRecord = bufferedReader.readLine(); employeeRecord != null; employeeRecord = bufferedReader.readLine()){
                System.out.println(employeeRecord);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
