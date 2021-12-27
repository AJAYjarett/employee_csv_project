package employee_csv_project.controller.csv_controller.csv_intake;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCsvParser {
    /**
     * Method retrieves employees data from csv file and refactor it for EmployeeDTO object.
     * @return Employee refactored data.
     */
    public static List<String[]> createEmployeeData(String fileLocation) {
        List<String[]> refactoredEmployeeDetails = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));
            bufferedReader.readLine();
            for (String employeeRecord = bufferedReader.readLine(); employeeRecord != null; employeeRecord = bufferedReader.readLine()) {
                refactoredEmployeeDetails.add(refactorEmployeeRecord(employeeRecord));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return refactoredEmployeeDetails;
    }

    private static String[] refactorEmployeeRecord(String employeeRecord) {
        String[] employeeDetails = employeeRecord.split(",");
        return employeeDetails;
    }

}
