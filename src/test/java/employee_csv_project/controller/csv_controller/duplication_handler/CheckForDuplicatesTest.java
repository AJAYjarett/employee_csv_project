package employee_csv_project.controller.csv_controller.duplication_handler;

import employee_csv_project.model.EmployeeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckForDuplicatesTest {

    @Test
    @DisplayName("Check For Duplicates Test")
    void checkForDuplicatesTest() {
        String[] employeeData1 = new String[]{"19846","Mrs.","Serafina","I","Bumgarner","F","serafina.bumgarner@exxonmobil.com","9/21/1982","2/1/2008","69294"};
        String[] employeeData2 = new String[]{"19846","Mrs.","Juliette","M","Rojo","F","juliette.rojo@yahoo.co.uk","5/8/1967","6/4/2011","193912"};

        EmployeeDTO employee = new EmployeeDTO(employeeData1);
        EmployeeDTO employee2 = new EmployeeDTO(employeeData2);
        CheckForDuplicates.checkForIdDuplicates(employee);
        CheckForDuplicates.checkForIdDuplicates(employee2);
        Assertions.assertEquals(0, CheckForDuplicates.getListOfNonDuplicatedEmployees().size());


    }
}
