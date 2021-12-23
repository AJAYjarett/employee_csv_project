package employee_csv_project.controller.csv_controller.duplication_handler;

import employee_csv_project.controller.logger.LogWriter;
import employee_csv_project.model.EmployeeDTO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;

public class CheckForDuplicates {
    private static ArrayList<EmployeeDTO> listOfNonDuplicatedEmployees = new ArrayList<>();
    private static ArrayList<EmployeeDTO> listOfDuplicatedEmployees = new ArrayList<>();

    public static boolean checkDuplicates(EmployeeDTO employee) {
        if (listOfNonDuplicatedEmployees.isEmpty()) {
            listOfNonDuplicatedEmployees.add(new EmployeeDTO(new String[]{"0", null, null, null, null, null,null,"1/1/2008", "1/1/2008", "1"}));
        } else {
            return checkForIdDuplicates(employee);
        }
        return true;
    }

    /**
     * Method checks if current employee is a duplicate. If true, it adds both duplicates to listOfDuplicatedEmployees list
     * and removes base duplicate from listOfNonDuplicatedEmployees list.
     * @param employee to check.
     * @return Boolean if employee is duplicate.
     */
    public static boolean checkForIdDuplicates(EmployeeDTO employee) {
        for (int i = 0; i < listOfNonDuplicatedEmployees.size(); i++) {
            if (employee.getEmployeeId() == listOfNonDuplicatedEmployees.get(i).getEmployeeId()) {
                listOfDuplicatedEmployees.add(employee);
                listOfDuplicatedEmployees.add(listOfNonDuplicatedEmployees.get(i));
                String firstEmployee = listOfNonDuplicatedEmployees.get(i).getEmployeeId() + " " + listOfNonDuplicatedEmployees.get(i).getFirstName() +
                        " " + listOfNonDuplicatedEmployees.get(i).getLastName();
                String secondEmployee = employee.getEmployeeId() + " " + employee.getFirstName() + " " + employee.getLastName();
                LogWriter.writeLog(Level.INFO, "Duplicate found:\n" + firstEmployee + "\n" + secondEmployee);
                listOfNonDuplicatedEmployees.remove(i);
                return false;
            }
        }
        listOfNonDuplicatedEmployees.add(employee);
        return true;
    }


    public static ArrayList<EmployeeDTO> getListOfNonDuplicatedEmployees() {
        return listOfNonDuplicatedEmployees;
    }

    public static ArrayList<EmployeeDTO> getListOfDuplicatedEmployees() {
        return listOfDuplicatedEmployees;
    }

    /**
     * Generated new csv file with duplicated employees data.
     * @param fileLocation csv file location.
     */
    public static void writeDuplicatesIntoFile(String fileLocation){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileLocation, true));
            for (int i = 0; i <listOfDuplicatedEmployees.size(); i++) {
                bufferedWriter.write(listOfDuplicatedEmployees.get(i).toString()+"\n");
                if(i==listOfDuplicatedEmployees.size()-1){
                    bufferedWriter.close();
                }
            }
            LogWriter.writeLog(Level.INFO, "Duplicate employees data has been written into EmployeeDuplicatesRecords.csv file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
