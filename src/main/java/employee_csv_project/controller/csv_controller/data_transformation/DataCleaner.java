package employee_csv_project.controller.csv_controller.data_transformation;

import java.sql.Date;

public class DataCleaner {

    /**
     * Method to format a date String
     * @param dateString the unformatted String
     * @return The date formatted to "MM/DD/YYYY"
     */
    public static Date formatDate(String dateString) {

        //Split the date into its constituent parts
        String[] date = dateString.split("/");

        // Month/Day/Year becomes Year/Month/Day

        return Date.valueOf(date[2] + "-" + date[0] + "-" + date[1]);
    }

}
