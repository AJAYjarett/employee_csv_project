package employee_csv_project.controller.csv_controller.data_validation;

import java.time.LocalDate;

public class DataValidator {
    /**
     * Method to validate that one date is before another
     * @param joinDate The later date
     * @param birthDate The earlier date
     * @return boolean whether the birthDate is before the joinDate
     */
    public static boolean validateDates(LocalDate birthDate, LocalDate joinDate) {
        return birthDate.isBefore(joinDate);
    }
}
