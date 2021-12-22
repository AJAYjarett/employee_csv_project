package employee_csv_project.controller;

import employee_csv_project.controller.csv_controller.data_transformation.DataCleaner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.fail;


public class DataCleanerTest {
    String badDate = "9/4/2008";
    String goodDate = "10/20/1994";
    LocalDate badLocalDate = LocalDate.of(2008,9,4);
    LocalDate goodLocalDate = LocalDate.of(1994,10,20);

    @Test
    @DisplayName("Test that incorrectly formatted date is formatted correctly")
    void testThatIncorrectlyFormattedDateIsFormattedCorrectly() {
        Assertions.assertEquals(badLocalDate, DataCleaner.formatDate(badDate));
    }

    @Test
    @DisplayName("Test that correctly formatted date is unchanged")
    void testThatCorrectlyFormattedDateIsUnchanged() {
        Assertions.assertEquals(goodLocalDate, DataCleaner.formatDate(goodDate));
    }
}
