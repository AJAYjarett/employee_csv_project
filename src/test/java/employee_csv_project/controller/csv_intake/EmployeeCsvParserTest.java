package employee_csv_project.controller.csv_intake;

import employee_csv_project.controller.csv_controller.csv_intake.EmployeeCsvParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeCsvParserTest {

    @Test
    @DisplayName("Employee Csv Parser Test")
    void employeeCsvParserTest() {
       List<String[]> expectedEmployeesList = new ArrayList<>();
        expectedEmployeesList.add(new String[]{"198429, Mrs., Serafina, I, Bumgarner, F, serafina.bumgarner@exxonmobil.com, 9/21/1982, 2/1/2008, 69294"});
        expectedEmployeesList.add(new String[]{"178566, Mrs., Juliette, M, Rojo, F, juliette.rojo@yahoo.co.uk, 5/8/1967, 6/4/2011, 193912"});
        Assertions.assertEquals(Arrays.toString(expectedEmployeesList.get(0)), Arrays.toString(EmployeeCsvParser.createEmployeeData("src/test/java/employee_csv_project/controller/csv_intake/TestEmployeeRecords.csv").get(0)));




    }
}
