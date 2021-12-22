package employee_csv_project.controller.csv_controller.data_transformation;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class SalaryValidater {
    public static boolean formatSalary (String givenSalary){
        if (givenSalary.matches("^[0-9]+$")) {
            return true;
        }
        else {
            return false;
        }
    }
    public static float convertSalaryToFloat(String givenSalary) {
        float salary = Float.parseFloat(givenSalary);
        return salary;
    }


}
