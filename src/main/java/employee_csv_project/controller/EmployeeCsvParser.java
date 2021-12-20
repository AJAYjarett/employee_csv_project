package employee_csv_project.controller;

import employee_csv_project.config.Config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCsvParser {
    private final List<String[]> refactoredEmployeeDetails = new ArrayList<>();

    public void createEmployeeData() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Config.employeeCsvFileLocation()));
            bufferedReader.readLine();
            for (String employeeRecord = bufferedReader.readLine(); employeeRecord != null; employeeRecord = bufferedReader.readLine()) {
                refactorEmployeeRecord(employeeRecord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void refactorEmployeeRecord(String employeeRecord) {
        String[] employeeDetails = employeeRecord.split(",");
        refactoredEmployeeDetails.add(employeeDetails);

    }

    public static void main(String[] args) {
    }

    public List<String[]> getRefactoredEmployeeDetails() {
        return refactoredEmployeeDetails;
    }
}
