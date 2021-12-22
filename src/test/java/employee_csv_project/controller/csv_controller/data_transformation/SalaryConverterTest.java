package employee_csv_project.controller.csv_controller.data_transformation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static employee_csv_project.controller.csv_controller.data_transformation.SalaryConverter.convertSalaryToFloat;

public class SalaryConverterTest {
    String salary = "65291";

    @Test
    @DisplayName("Test that Salary string becomes float")
    void testThatSalaryStringBecomesFloat() {
        Assertions.assertEquals(65291.0, convertSalaryToFloat(salary));
    }
}
