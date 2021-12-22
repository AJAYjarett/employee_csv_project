package employee_csv_project.controller.csv_controller.duplication_handler;

import employee_csv_project.model.EmployeeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DuplicatesRefactorTest {

    @Test
    @DisplayName("Duplicates Refactor Test")
    void duplicatesRefactorTest() {
        //add employee to listOfNonDuplicatedEmployees
        EmployeeDTO firstEmployee = new EmployeeDTO(new String[]{"19846", "Mrs.", "Serafina", "I", "Bumgarner", "F", "serafina.bumgarner@exxonmobil.com", "9/21/1982", "2/1/2008", "69294"});
        ArrayList<EmployeeDTO> employeesList = new ArrayList<>();
        employeesList.add(firstEmployee);
        CheckForDuplicates.setListOfNonDuplicatedEmployees(employeesList);

        //create new employee with the same ID
        String[] employeeData2 = new String[]{"19846", "Mrs.", "Juliette", "M", "Rojo", "F", "juliette.rojo@yahoo.co.uk", "5/8/1967", "6/4/2011", "193912"};
        EmployeeDTO duplicatedEmployee = new EmployeeDTO(employeeData2);

        EmployeeDTO expectedEmployee = new EmployeeDTO(employeeData2);
        expectedEmployee.setEmployeeId(expectedEmployee.getEmployeeId()+1);
        Assertions.assertEquals(expectedEmployee.getEmployeeId(), DuplicatesRefactor.refactorEmployeeId(duplicatedEmployee).getEmployeeId());

    }
}
