package employee_csv_project.controller.csv_controller.data_transformation;

public class DataCleaner {

    /**
     * Method to format a date String
     * @param dateString the unformatted String
     * @return The date formatted to "MM/DD/YYYY"
     */
    public static String formatDate(String dateString) {
        //Split the date into its constituent parts
        String[] date = dateString.split("/");

        //Initialise the return String as blank
        StringBuilder formattedDateString = new StringBuilder();

        for (String dateElement : date) {
            if(dateElement.length() < 2) {
                //Standardise single digit days/months from '3' to '03'
                dateElement = "0" + dateElement;
            }

            //Add formatted elements to return String
            formattedDateString.append("/").append(dateElement);
        }
        return formattedDateString.substring(1);
    }


}
