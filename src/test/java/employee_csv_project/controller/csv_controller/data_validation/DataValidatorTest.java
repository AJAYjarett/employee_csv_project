package employee_csv_project.controller.csv_controller.data_validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static employee_csv_project.controller.csv_controller.data_validation.DataValidator.*;
import static org.junit.jupiter.api.Assertions.fail;

public class DataValidatorTest {
    Date earlyDate = Date.valueOf("2000-10-24");
    Date lateDate = Date.valueOf("2020-09-21");

    String badEmail = "notvalid@badEmailplace.org.atSymbol@";
    String goodEmail = "legitemail@niceEmailProvider.com";

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
        Assertions.assertFalse(validateGender("O"));
    }

    @Test
    @DisplayName("Test that a valid email returns valid")
    void testThatAValidEmailReturnsValid() {
        Assertions.assertTrue(validateEmail(goodEmail));
    }

    @Test
    @DisplayName("Test that an invalid email returns invalid")
    void testThatAnInvalidEmailReturnsInvalid() {
        Assertions.assertFalse(validateEmail(badEmail));
    }

    @Test
    @DisplayName("Test that a valid Salary returns true")
    void testThatAValidSalaryReturnsTrue() {
        Assertions.assertTrue(formatIdOrSalary("19854"));
    }

    @Test
    @DisplayName("Test that an invalid salary returns false")
    void testThatAnInvalidSalaryReturnsFalse() {
        Assertions.assertFalse(formatIdOrSalary("Money"));
    }
    
}
