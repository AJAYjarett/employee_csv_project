package employee_csv_project.controller.csv_controller.data_validation;

import employee_csv_project.controller.csv_controller.data_transformation.DataCleaner;

import java.sql.Date;

public class EmployeeCheck {
    public static boolean checkEmployeeIsValid(String[] employee){

        //boolean checkEmployeeId;
        //boolean checkNamePrefix;
        //boolean checkFirstName;
        boolean checkMiddleInit = DataValidator.validateMiddleInit(employee[3]);
        //boolean checkLastName;
        boolean checkGender = DataValidator.validateGender(employee[5]);;
        boolean checkEMail = DataValidator.validateEmail(employee[6]);
        Date dateOfBirth = DataCleaner.formatDate(employee[7]);
        Date dateOfJoining = DataCleaner.formatDate(employee[8]);;
        boolean checkDobBeforeDateOfJoining = DataValidator.validateDates(dateOfBirth,dateOfJoining);
        boolean checkSalary = DataValidator.formatSalary(employee[9]);

        if (checkMiddleInit && checkGender && checkEMail && checkDobBeforeDateOfJoining && checkSalary){
            return true;
        }
        else
            return false;
    }

}
