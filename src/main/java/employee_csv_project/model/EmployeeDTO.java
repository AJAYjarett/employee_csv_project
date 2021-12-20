package employee_csv_project.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeDTO {

    private int employeeId;
    private String namePrefix;
    private String firstName;
    private String middleInit;
    private String lastName;
    private String gender;
    private String eMail;
    private LocalDate dob;
    private LocalDate dateOfJoining;
    private int salary;

    public EmployeeDTO(String[] employeeData) {

    }


    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = LocalDate.parse(dateOfJoining, DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy"));
    }

    public void setDob(String dob) {
        this.dob = LocalDate.parse(dob, DateTimeFormatter.ofPattern("M[M]/d[d]/yyyy"));
    }
}
