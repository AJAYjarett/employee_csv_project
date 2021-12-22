package employee_csv_project.controller.csv_controller.data_validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static employee_csv_project.controller.csv_controller.data_validation.DataValidator.validateDates;
import static employee_csv_project.controller.csv_controller.data_validation.DataValidator.validateGender;
import static org.junit.jupiter.api.Assertions.fail;

public class DataValidatorTest {
    LocalDate earlyDate = LocalDate.of(2000, 4,10);
    LocalDate lateDate = LocalDate.of(2020, 4,10);

    @Test
    @DisplayName("Test that later date is not before earlier date")
    void testThatLaterDateIsNotBeforeEarlierDate() {
        Assertions.assertFalse(validateDates(lateDate, earlyDate));
    }

    @Test
    @DisplayName("Test that earlier date is before later date")
    void testThatEarlierDateIsBeforeLaterDate() {
        Assertions.assertTrue(validateDates(earlyDate, lateDate));
    }

    @Test
    @DisplayName("Test that a valid gender returns valid")
    void testThatAValidGenderReturnsValid() {
        Assertions.assertTrue(validateGender("M"));
    }

    @Test
    @DisplayName("Test that an invalid gender returns invalid")
    void testThatAnInvalidGenderReturnsInvalid() {
        Assertions.assertFalse(validateGender("O"));    }
}
