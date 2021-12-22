package employee_csv_project.controller.csv_controller.data_transformation;

public class SalaryConverter {

    public static float convertSalaryToFloat(String givenSalary) {
        float salary = Float.parseFloat(givenSalary);
        return salary;
    }


}
