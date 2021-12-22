package employee_csv_project.controller.csv_controller.data_validation;

import java.time.LocalDate;

public class DataValidator {

    public static boolean validateName(String namePrefix){
        return namePrefix.matches("^[A-Za-z+_.-]+$");
    }

    public static boolean validateNamePrefix(String namePrefix){
        String[] prefixes = {"1st Lt", "Adm","Atty","Brother","Capt","Chief","Cmdr","Col",
                "Dean","Dr","Drs","Elder","Father","Gen","Gov","Hon","Lt Col.","Maj","MSgt","Mr",
                "Mrs","Ms","Prince","Prof","Rabbi","Rev","Sister"};
        for (int i = 0; i < prefixes.length; i++) {
            if (namePrefix.equals(prefixes[i]+".")) return true;
            else if (namePrefix.equals(prefixes[i])) return true;
        }
        return false;
    }
    public static boolean validateMiddleInit(String middleInitial){
        return middleInitial.length() == 1;
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
    public static boolean formatIdOrSalary (String givenIdOrSalary){
        return givenIdOrSalary.matches("^[0-9]+$");
    }
}
