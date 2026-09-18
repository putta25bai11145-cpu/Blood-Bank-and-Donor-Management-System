# Blood-Bank-and-Donor-Management-System
A Java-based Blood Bank Management System that handles donor registration, blood stock tracking, and requests via a console interface. It validates user inputs, filters records, and saves data persistently to local text files (donors.txt and blood_stock.txt).
**OVERVIEW OF THE PROJECT**
The Blood Bank and Donor Management System is a lightweight console-based Java application that was designed to support blood bank management, donor management, and inventory control. The program allows the user to manage the records of blood donors, monitor the stocks of blood per blood type, and process blood requests from patients, which automatically reduces the blood inventory.
The application stores all data in a file-based database stored locally within the application directory, hence no external database connection or drivers are needed.

**FEATURES**
Donor Registration & Management: Register new donors with automated input validation (e.g., eligible age range of 18–65, valid blood group formats, and duplicate ID checks).
Search & Filter: Search registered donors by blood group or location/city.
Stock & Inventory Tracking: Easily restock blood supplies or add new blood types to keep your inventory up to date. 
Smart Blood Requests:Automatically verifies blood availability and deducts units as soon as a request is approved.  
Persistent Data Storage: Automatically saves and loads your data using donors.txt and blood_stock.txt so nothing gets lost when you exit. 
Robust Error Handling:Prevents crashes by catching typos, invalid menu choices, and accidental text inputs. 
Technologies / Tools Used
Programming Language: Java (JDK 8 or higher)
Development Environment: VS Code / Eclipse / IntelliJ IDEA / Terminal
Data Persistence: File I/O (BufferedReader, BufferedWriter, CSV format)
Version Control: Git & GitHub
**Steps to Install & Run the Project**
Prerequisites
Make sure you have Java Development Kit (JDK) installed on your system. You can verify this by running:
java -version

Installation & Execution
Clone the repository:
git clone https://github.com/your-username/blood-bank-management-system.git
cd blood-bank-management-system


Compile the Java file:
javac BloodBankAndDonorManagementSystem.java


Run the program:
java BloodBankAndDonorManagementSystem


**Instructions for Testing**
Follow these steps to test the main features of the system:
Test Donor Addition (Option 1):
Enter a unique Donor ID (e.g., 101).
Enter Name, Age (must be 18–65), Gender, Blood Group (e.g., O+), Phone, and City.
Verify that donors.txt updates with the new entry.
Test Search Functions (Options 3 & 4):
Search by the registered blood group (e.g., O+) or city to confirm the record appears.
Test Blood Stock Management (Options 5 & 6):
Select option 6 to view current default stock levels.
Select option 5 to add 5 units to O+. Check your stock list again to make sure the unit counts went up. 
Test Request Blood (Option 7):
Request 2 units of O+ blood. Make sure the request was approved, then select option 6 to confirm that 2 units were deducted. 
Try requesting a huge amount (e.g., 50 units) to verify stock shortage warnings.
Test Data Persistence:
Exit the program (Option 8) and restart it. View donors and stock to verify saved state.

**OUTPUT:**
====================================================
       BLOOD BANK AND DONOR MANAGEMENT SYSTEM
====================================================

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
Enter your choice:
