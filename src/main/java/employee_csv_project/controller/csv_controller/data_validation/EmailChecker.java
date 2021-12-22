package employee_csv_project.controller.csv_controller.data_validation;

public class EmailChecker {

    public static boolean validateEmail(String emailToCheck){
        return emailToCheck.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
}
