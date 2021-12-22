package employee_csv_project.model;

public class EmployeeDTO {

    private int employeeId;
    private String namePrefix;
    private String firstName;
    private String middleInit;
    private String lastName;
    private String gender;
    private String eMail;
    private String dob;
    private String dateOfJoining;
    private int salary;

    public EmployeeDTO(String[] employeeData) {
        this.employeeId = Integer.parseInt(employeeData[0]);
        this.namePrefix = employeeData[1];
        this.firstName = employeeData[2];
        this.middleInit = employeeData[3];
        this.lastName = employeeData[4];
        this.gender = employeeData[5];
        this.eMail = employeeData[6];
        this.dob = employeeData[7];
        this.dateOfJoining = employeeData[8];
        this.salary = Integer.parseInt(employeeData[9]);
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

    public String geteMail() {
        return eMail;
    }

    public String getDob() {
        return dob;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public int getSalary() {
        return salary;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
