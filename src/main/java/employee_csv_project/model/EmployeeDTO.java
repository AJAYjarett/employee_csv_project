package employee_csv_project.model;

import employee_csv_project.controller.csv_controller.data_transformation.DataCleaner;
import employee_csv_project.controller.csv_controller.data_transformation.SalaryConverter;

import java.sql.Date;

public class EmployeeDTO {

    private int employeeId;
    private String namePrefix;
    private String firstName;
    private String middleInit;
    private String lastName;
    private String gender;
    private String eMail;
    private Date dob;
    private Date dateOfJoining;
    private float salary;

    public EmployeeDTO(String[] employeeData) {
        this.employeeId = Integer.parseInt(employeeData[0]);
        this.namePrefix = employeeData[1];
        this.firstName = employeeData[2];
        this.middleInit = employeeData[3];
        this.lastName = employeeData[4];
        this.gender = employeeData[5];
        this.eMail = employeeData[6];
        this.dob = DataCleaner.formatDate(employeeData[7]);
        this.dateOfJoining = DataCleaner.formatDate(employeeData[8]);
        this.salary = SalaryConverter.convertSalaryToFloat(employeeData[9]);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInit() {
        return middleInit;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return eMail;
    }

    public Date getDob() {
        return dob;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public float getSalary() {
        return salary;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeId=" + employeeId +
                ", namePrefix='" + namePrefix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleInit='" + middleInit + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", eMail='" + eMail + '\'' +
                ", dob=" + dob +
                ", dateOfJoining=" + dateOfJoining +
                ", salary=" + salary +
                '}';
    }
}
