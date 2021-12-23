#Employee CSV Project
A group project by Hanif Ali, Pawel Dyjak, Alexander Jarrett and Harry Jones

##Table of contents




#Project Specification
This program takes data about a collection of employees from a CSV file and translates
that into a MYSQL database. 


#Instructions of use
The details of the CSV file and the SQL server must be provided by a config.properties 
file provided by the user.
The fields that must be present in the config is:
* employee_csv_file_location
* db_connection
* username
* password
* db_name

Where username and password are for the SQL server.

How the Program Works
- The given CSV file of employees will be imported into the program
- Each employee record will go through a validation check
- Next, each one of the fields of a employee record will be reformatted(e.g for a date, String format to Date format)
- Next, will check if any duplication of IDs exist within the employee records
     - if duplications found, employees with duplicate IDs wont be placed into database. 
- Finally, all valid employees will be pushed to the database
