package employee_csv_project.controller.csv_controller.data_validation;

import employee_csv_project.controller.csv_controller.data_transformation.DataCleaner;
import employee_csv_project.controller.logger.LogWriter;

import java.sql.Date;
import java.util.Arrays;
import java.util.logging.Level;

public class EmployeeCheck {
    public static boolean checkEmployeeIsValid(String[] employee){

        boolean checkEmployeeId = DataValidator.formatIdOrSalary(employee[0]);
        boolean checkNamePrefix = DataValidator.validateNamePrefix(employee[1]);
        boolean checkFirstName = DataValidator.validateName(employee[2]);
        boolean checkMiddleInit = DataValidator.validateMiddleInit(employee[3]);
        boolean checkLastName = DataValidator.validateName(employee[4]);
        boolean checkGender = DataValidator.validateGender(employee[5]);
        boolean checkEmail = DataValidator.validateEmail(employee[6]);
        Date dateOfBirth = DataCleaner.formatDate(employee[7]);
        Date dateOfJoining = DataCleaner.formatDate(employee[8]);
        boolean checkDobBeforeDateOfJoining = DataValidator.validateDates(dateOfBirth,dateOfJoining);
        boolean checkSalary = DataValidator.formatIdOrSalary(employee[9]);

        if (checkEmployeeId && checkNamePrefix && checkFirstName && checkMiddleInit && checkLastName &&
                checkGender && checkEmail && checkDobBeforeDateOfJoining && checkSalary){
            return true;
        }
        else{
            LogWriter.writeLog(Level.INFO, "For Employer: " + Arrays.toString(employee));
            if (!checkEmployeeId) LogWriter.writeLog(Level.INFO, "Employee ID given invalid: "+employee[0]);
            if (!checkNamePrefix) LogWriter.writeLog(Level.INFO, "Name Prefix given invalid: "+employee[1]);
            if (!checkFirstName) LogWriter.writeLog(Level.INFO, "First Name given invalid: "+employee[2]);
            if (!checkMiddleInit) LogWriter.writeLog(Level.INFO, "Middle Initial given invalid: "+employee[3]);
            if (!checkLastName) LogWriter.writeLog(Level.INFO, "Last Name given invalid: "+employee[4]);
            if (!checkGender) LogWriter.writeLog(Level.INFO, "Gender given invalid: "+employee[5]);
            if (!checkEmail) LogWriter.writeLog(Level.INFO, "Email given invalid: "+employee[6]);
            if (!checkDobBeforeDateOfJoining) LogWriter.writeLog(Level.INFO, "Date of joining before DOB");
            if (!checkSalary) LogWriter.writeLog(Level.INFO, "Salary given invalid: "+employee[8]);

            return false;
        }
    }

}
