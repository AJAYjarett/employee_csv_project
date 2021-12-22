package employee_csv_project.controller.csv_controller.data_validation;

import java.time.LocalDate;

public class DataValidator {

    public static boolean validateMiddleInit(String middleInitial){
        if (middleInitial.length() == 1){
            return true;
        }
        return false;
    }

    /**
     * Method to validate that one date is before another
     * @param joinDate The later date
     * @param birthDate The earlier date
     * @return boolean whether the birthDate is before the joinDate
     */
    public static boolean validateDates(LocalDate birthDate, LocalDate joinDate) {
        return birthDate.isBefore(joinDate);
    }

    /**
     * Method to validate gender attribute
     * @param gender The gender to check
     * @return boolean whether the gender is valid
     */
    public static boolean validateGender(String gender) {
        return (gender.equals("M") || gender.equals("F"));
    }
    public static boolean validateEmail(String emailToCheck){
        return emailToCheck.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
    public static boolean formatSalary (String givenSalary){
        if (givenSalary.matches("^[0-9]+$")) {
            return true;
        }
        else {
            return false;
        }
    }
}
