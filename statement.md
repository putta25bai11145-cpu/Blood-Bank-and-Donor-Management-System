BLOOD Donor MANAGEMENT SYSTEM

1. Project

Blood Bank and Donor Management System

2. Problem Statement

Managing blood donors and blood‑stock information manually can be difficult and time‑consuming. Maintaining donor details searching for donors by blood group or city keeping track of blood units and processing blood requests requires an organized system.

The Blood Bank and Donor Management System is a Java‑based console application created to make these tasks easier. The Blood Bank and Donor Management System keeps donor information and blood‑stock details by using Java "ArrayList" collections. Saves the data permanently in text files.

The application lets the user register donors view donor records search donors by blood group or by city add blood units to the blood bank view the available blood stock and process blood requests depending on the availability of the required blood group.

3. Objectives

1. The Blood Bank and Donor Management System will keep donor information organized.

2. The Blood Bank and Donor Management System will register blood donors.

3. The Blood Bank and Donor Management System will search donors by blood group.

4. The Blood Bank and Donor Management System will search donors by city.

5. The Blood Bank and Donor Management System will keep the blood‑stock information.

6. The Blood Bank and Donor Management System will add blood units to the blood bank.

7. The Blood Bank and Donor Management System will process blood requests according to stock.

8. The Blood Bank and Donor Management System will prevent donor IDs.

9. The Blood Bank and Donor Management System will validate donor age and blood‑group information.

10. The Blood Bank and Donor Management System will store donor and blood‑stock data permanently using text files.

11. The Blood Bank and Donor Management System will provide an user‑friendly menu‑driven interface.

12. The Blood Bank and Donor Management System will demonstrate the use of Java OOP concepts and file handling.

4. Technologies Used

- Programming Language: Java

- Concepts Used: Object‑Oriented Programming, Classes, Objects, ArrayList, Loops, Conditional Statements, Methods, Exception Handling

- File Handling: "FileReader" "FileWriter" "BufferedReader" "BufferedWriter"

- Input Handling: "Scanner"

- Data Storage: Text files (“donors.txt". Blood_stock.txt”)

- Development Environment: VS Code / Java JDK

5. Main Features

5.1 Add New Donor

The Blood Bank and Donor Management System lets the user enter a Donor ID, Donor Name, Age, Gender, Blood Group, Phone Number and City. The Blood Bank and Donor Management System checks if the Donor ID already exists. The Blood Bank and Donor Management System also checks that the donor’s age and blood group are valid before storing the donor.

5.2 View All Donors

The Blood Bank and Donor Management System shows all donors and their full details.

5.3 Search Donor by Blood Group

The Blood Bank and Donor Management System lets the user type a blood group like "A+" "B-“ "O+" or "AB+”. The Blood Bank and Donor Management System then searches the donor list. Shows donors with that blood group.

5.4 Search Donor by City

The Blood Bank and Donor Management System lets the user type a city name. The Blood Bank and Donor Management System then shows donors who registered in that city.

5.5 Add Blood Stock

The Blood Bank and Donor Management System allows the user to add blood units for a blood group. If the blood group is already present in the stock the Blood Bank and Donor Management System adds the units to the current quantity.

5.6 View Blood Stock

The Blood Bank and Donor Management System shows the blood groups and how many units each has.

5.7 Request Blood

The Blood Bank and Donor Management System lets the user type a Patient Name, the Required Blood Group and the Required Units. The Blood Bank and Donor Management System checks the stock. If enough units exist the Blood Bank and Donor Management System removes those units from the stock. Approves the request. If not enough units exist the Blood Bank and Donor Management System rejects the request.

5.8 File Storage

The Blood Bank and Donor Management System keeps information in text files so data stays after the program closes. The file "donors.txt" stores donor information. The file "blood_stock.txt" stores blood‑stock information. When the program starts the Blood Bank and Donor Management System loads existing data from these files.

6. Classes Used

Donor Class

The Donor Class represents a blood donor. It contains id, name, age, gender, bloodGroup, phone and city. It also has methods to show donor information and to convert donor data to and from text‑file format.

BloodStock Class

The BloodStock Class represents blood‑stock information. It contains bloodGroup and units. It provides methods to convert blood‑stock information to and, from text‑file format.

7. Data Structures Used

The project uses Javas "ArrayList":

ArrayList<Donor> donors

to store donor records.

Another "ArrayList" is used for blood stock:

ArrayList<BloodStock> bloodStock

"ArrayList" is suitable because the number of donors and blood-stock records can change dynamically during program execution.

8. File Handling

The project uses Java file-handling classes to provide storage.

Donor File

donors.txt

stores donor information in comma-separated format.

Example:

101,Rahul,25,Male O+,9876543210,Bhopal

Blood Stock File

blood_stock.txt

stores blood group and units.

Example:

A+,10

O+,12

B+,8

The program reads these files when it starts and updates them whenever donor or stock information changes.

9. Validation

The system performs validations:

- Donor ID must be unique.

- Donor age must be between 18 and 65.

- Blood group must be one of:

A+

A-

B+

B-

AB+

AB-

O+

O-

- Number of blood units must be greater than zero.

- Invalid menu inputs are handled using exception handling.

10. Menu Structure

The application provides the following menu:

--------------- MAIN MENU ----------------

1. Add New Donor

2. View All Donors

3. Search Donor by Blood Group

4. Search Donor by City

5. Add Blood Stock

6. View Blood Stock

7. Request Blood

8. Exit

------------------------------------------

11. Working of the System

The working process of the system is:

1. The program starts.

2. Existing donor and blood-stock data are loaded from text files.

3. The main menu is displayed.

4. The user selects an operation.

5. The selected operation is executed.

6. Donor or blood-stock information is updated when required.

7. Updated information is saved back into the corresponding text file.

8. The program continues displaying the menu until the user selects Exit.

12. Expected Outcome

The proposed system provides a computerized method for managing blood donors and blood-stock records. It reduces the need for record keeping and makes searching adding and updating information easier.

The project also demonstrates implementation of Java concepts such as:

- Classes and Objects

- Encapsulation

- ArrayList

- Methods

- Loops

- Conditional Statements

- Exception Handling

- String Handling

- File Input/Output

13.

The Blood Bank and Donor Management System is a Java-based application designed to manage donor records and blood-stock information. It provides operations such as donor registration, donor searching, stock management and blood-request processing.

The use of "ArrayList" makes the data management flexible while file handling provides storage. The project can be further enhanced by adding features such, as a graphical user interface, database connectivity, donor eligibility tracking, blood-request history, login authentication and automatic compatibility checking between blood groups.
