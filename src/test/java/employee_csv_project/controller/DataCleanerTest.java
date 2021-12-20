package employee_csv_project.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;


public class DataCleanerTest {
    String badDate = "9/4/2008";
    String goodDate = "10/20/1994";

    @Test
    @DisplayName("Test that incorrectly formatted date is formatted correctly")
    void testThatIncorrectlyFormattedDateIsFormattedCorrectly() {
        Assertions.assertEquals("09/04/2008", DataCleaner.formatDate(badDate));
    }

    @Test
    @DisplayName("Test that correctly formatted date is unchanged")
    void testThatCorrectlyFormattedDateIsUnchanged() {
        Assertions.assertEquals(goodDate, DataCleaner.formatDate(goodDate));
    }
}
