package employee_csv_project.model;

import employee_csv_project.controller.DataCleaner;
import java.time.LocalDate;

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
        this.employeeId = Integer.parseInt(employeeData[0]);
        this.namePrefix = employeeData[1];
        this.firstName = employeeData[2];
        this.middleInit = employeeData[3];
        this.lastName = employeeData[4];
        this.gender = employeeData[5];
        this.eMail = employeeData[6];
        this.dob = LocalDate.parse(DataCleaner.formatDate(employeeData[7]));
        this.dateOfJoining = LocalDate.parse(DataCleaner.formatDate(employeeData[8]));
        this.salary = Integer.parseInt(employeeData[9]);
    }
}
