package employee_csv_project.controller.csv_controller.data_transformation;

import java.time.LocalDate;

public class DataCleaner {

    /**
     * Method to format a date String
     * @param dateString the unformatted String
     * @return The date formatted to "MM/DD/YYYY"
     */
    public static LocalDate formatDate(String dateString) {

        //Split the date into its constituent parts
        String[] date = dateString.split("/");

        // Month/Day/Year becomes Year/Month/Day

        return LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[0]),Integer.parseInt(date[1]));
    }

}
