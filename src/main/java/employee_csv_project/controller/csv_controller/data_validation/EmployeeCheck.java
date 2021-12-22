package employee_csv_project.controller.csv_controller.data_validation;

import employee_csv_project.controller.csv_controller.data_transformation.DataCleaner;
import employee_csv_project.controller.csv_controller.data_transformation.SalaryValidater;

import java.time.LocalDate;

public class EmployeeCheck {
    public static boolean checkEmployeeIsValid(String[] employee){

        //boolean checkEmployeeId;
        //boolean checkNamePrefix;
        //boolean checkFirstName;
        boolean checkMiddleInit = DataValidator.validateMiddleInit(employee[3]);
        //boolean checkLastName;
        boolean checkGender = DataValidator.validateGender(employee[5]);;
        boolean checkEMail = EmailChecker.validateEmail(employee[6]);
        LocalDate dateOfBirth = DataCleaner.formatDate(employee[7]);
        LocalDate dateOfJoining = DataCleaner.formatDate(employee[8]);;
        boolean checkDobBeforeDateOfJoining = DataValidator.validateDates(dateOfBirth,dateOfJoining);
        boolean checkSalary = SalaryValidater.formatSalary(employee[9]);

        if (checkMiddleInit && checkGender && checkEMail && checkDobBeforeDateOfJoining && checkSalary){
            return true;
        }
        else
            return false;
    }

}
