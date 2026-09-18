import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BloodBankAndDonorManagementSystem {

    static Scanner scanner = new Scanner(System.in);

    // Store all donors
    static ArrayList<Donor> donors = new ArrayList<>();

    // Store blood stock
    static ArrayList<BloodStock> bloodStock = new ArrayList<>();

    // Text File Paths (saved directly in the project root directory in VS Code)
    private static final String DONORS_FILE = "donors.txt";
    private static final String STOCK_FILE = "blood_stock.txt";

    // =========================================================
    // DONOR CLASS
    // =========================================================

    static class Donor {

        int id;
        String name;
        int age;
        String gender;
        String bloodGroup;
        String phone;
        String city;

        Donor(int id, String name, int age, String gender,
              String bloodGroup, String phone, String city) {

            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.bloodGroup = bloodGroup;
            this.phone = phone;
            this.city = city;
        }

        void display() {

            System.out.println("--------------------------------------------");
            System.out.println("Donor ID     : " + id);
            System.out.println("Name         : " + name);
            System.out.println("Age          : " + age);
            System.out.println("Gender       : " + gender);
            System.out.println("Blood Group  : " + bloodGroup);
            System.out.println("Phone        : " + phone);
            System.out.println("City         : " + city);
            System.out.println("--------------------------------------------");
        }

        // Convert object to a single line CSV for file storage
        String toFileString() {
            return id + "," + name + "," + age + "," + gender + "," + bloodGroup + "," + phone + "," + city;
        }

        // Reconstruct object from CSV line
        static Donor fromFileString(String line) {
            String[] parts = line.split(",");
            if (parts.length < 7) return null;
            return new Donor(
                    Integer.parseInt(parts[0]),
                    parts[1],
                    Integer.parseInt(parts[2]),
                    parts[3],
                    parts[4],
                    parts[5],
                    parts[6]
            );
        }
    }

    // =========================================================
    // BLOOD STOCK CLASS
    // =========================================================

    static class BloodStock {

        String bloodGroup;
        int units;

        BloodStock(String bloodGroup, int units) {

            this.bloodGroup = bloodGroup;
            this.units = units;
        }

        String toFileString() {
            return bloodGroup + "," + units;
        }

        static BloodStock fromFileString(String line) {
            String[] parts = line.split(",");
            if (parts.length < 2) return null;
            return new BloodStock(parts[0], Integer.parseInt(parts[1]));
        }
    }

    // =========================================================
    // MAIN METHOD
    // =========================================================

    public static void main(String[] args) {

        // Load existing data from text files at startup
        loadDataFromFiles();

        System.out.println();
        System.out.println("====================================================");
        System.out.println("       BLOOD BANK AND DONOR MANAGEMENT SYSTEM");
        System.out.println("====================================================");

        while (true) {

            displayMenu();

            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            int choice;

            try {

                choice = Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println("\nPlease enter a number from 1 to 8.");
                continue;
            }

            switch (choice) {

                case 1:
                    addDonor();
                    break;

                case 2:
                    viewAllDonors();
                    break;

                case 3:
                    searchByBloodGroup();
                    break;

                case 4:
                    searchByCity();
                    break;

                case 5:
                    addBloodStock();
                    break;

                case 6:
                    viewBloodStock();
                    break;

                case 7:
                    requestBlood();
                    break;

                case 8:
                    System.out.println("\n====================================================");
                    System.out.println("Thank you for using the Blood Bank Management System!");
                    System.out.println("====================================================");

                    scanner.close();
                    return;

                default:
                    System.out.println("\nInvalid choice!");
                    System.out.println("Please select a number from 1 to 8.");
            }
        }
    }

    // =========================================================
    // DISPLAY MENU
    // =========================================================

    static void displayMenu() {

        System.out.println();
        System.out.println("--------------- MAIN MENU ----------------");
        System.out.println("1. Add New Donor");
        System.out.println("2. View All Donors");
        System.out.println("3. Search Donor by Blood Group");
        System.out.println("4. Search Donor by City");
        System.out.println("5. Add Blood Stock");
        System.out.println("6. View Blood Stock");
        System.out.println("7. Request Blood");
        System.out.println("8. Exit");
        System.out.println("------------------------------------------");
        System.out.print("Enter your choice: ");
    }

    // =========================================================
    // ADD DONOR
    // =========================================================

    static void addDonor() {

        System.out.println();
        System.out.println("=============== ADD NEW DONOR ===============");

        int id = readInteger("Enter Donor ID: ");

        // Check duplicate ID
        for (Donor donor : donors) {

            if (donor.id == id) {

                System.out.println("\nA donor with this ID already exists!");
                return;
            }
        }

        System.out.print("Enter Donor Name: ");
        String name = scanner.nextLine().trim();

        int age = readInteger("Enter Age: ");

        if (age < 18 || age > 65) {

            System.out.println("\nDonor age must be between 18 and 65.");
            return;
        }

        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine().trim();

        System.out.print("Enter Blood Group: ");
        String bloodGroup = scanner.nextLine().trim().toUpperCase();

        if (!isValidBloodGroup(bloodGroup)) {

            System.out.println("\nInvalid blood group!");
            System.out.println("Valid groups are:");
            System.out.println("A+, A-, B+, B-, AB+, AB-, O+, O-");
            return;
        }

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine().trim();

        System.out.print("Enter City: ");
        String city = scanner.nextLine().trim();

        Donor donor = new Donor(
                id,
                name,
                age,
                gender,
                bloodGroup,
                phone,
                city
        );

        donors.add(donor);
        saveDonorsToFile(); // Save changes to text file

        System.out.println();
        System.out.println("********************************************");
        System.out.println("       DONOR ADDED & SAVED TO FILE!");
        System.out.println("********************************************");
    }

    // =========================================================
    // VIEW ALL DONORS
    // =========================================================

    static void viewAllDonors() {

        System.out.println();
        System.out.println("=============== ALL DONORS ===============");

        if (donors.size() == 0) {

            System.out.println("\nNo donors have been registered yet.");
            return;
        }

        System.out.println("\nTotal Donors: " + donors.size());

        for (Donor donor : donors) {

            donor.display();
        }
    }

    // =========================================================
    // SEARCH BY BLOOD GROUP
    // =========================================================

    static void searchByBloodGroup() {

        System.out.println();
        System.out.println("========== SEARCH BY BLOOD GROUP ==========");

        System.out.print("Enter Blood Group: ");
        String bloodGroup = scanner.nextLine().trim().toUpperCase();

        if (!isValidBloodGroup(bloodGroup)) {

            System.out.println("\nInvalid blood group!");
            return;
        }

        boolean found = false;

        for (Donor donor : donors) {

            if (donor.bloodGroup.equals(bloodGroup)) {

                donor.display();
                found = true;
            }
        }

        if (!found) {

            System.out.println();
            System.out.println("No donor found with blood group: " + bloodGroup);
        }
    }

    // =========================================================
    // SEARCH BY CITY
    // =========================================================

    static void searchByCity() {

        System.out.println();
        System.out.println("=============== SEARCH BY CITY ===============");

        System.out.print("Enter City: ");
        String city = scanner.nextLine().trim();

        boolean found = false;

        for (Donor donor : donors) {

            if (donor.city.equalsIgnoreCase(city)) {

                donor.display();
                found = true;
            }
        }

        if (!found) {

            System.out.println();
            System.out.println("No donors found in " + city);
        }
    }

    // =========================================================
    // ADD BLOOD STOCK
    // =========================================================

    static void addBloodStock() {

        System.out.println();
        System.out.println("=============== ADD BLOOD STOCK ===============");

        System.out.print("Enter Blood Group: ");
        String bloodGroup = scanner.nextLine().trim().toUpperCase();

        if (!isValidBloodGroup(bloodGroup)) {

            System.out.println("\nInvalid blood group!");
            return;
        }

        int units = readInteger("Enter Number of Units: ");

        if (units <= 0) {

            System.out.println("\nNumber of units must be greater than 0.");
            return;
        }

        // Check if blood group already exists
        for (BloodStock stock : bloodStock) {

            if (stock.bloodGroup.equals(bloodGroup)) {

                stock.units += units;
                saveStockToFile(); // Save changes to text file

                System.out.println();
                System.out.println(units + " units of " + bloodGroup
                        + " added successfully!");

                System.out.println("Updated stock: "
                        + stock.units + " units");

                return;
            }
        }

        // If blood group doesn't exist
        bloodStock.add(new BloodStock(bloodGroup, units));
        saveStockToFile(); // Save changes to text file

        System.out.println();
        System.out.println("Blood stock added and saved successfully!");
    }

    // =========================================================
    // VIEW BLOOD STOCK
    // =========================================================

    static void viewBloodStock() {

        System.out.println();
        System.out.println("=============== BLOOD STOCK ===============");

        System.out.println();
        System.out.printf("%-15s %-10s%n", "Blood Group", "Units");
        System.out.println("--------------------------------");

        for (BloodStock stock : bloodStock) {

            System.out.printf(
                    "%-15s %-10d%n",
                    stock.bloodGroup,
                    stock.units
            );
        }
    }

    // =========================================================
    // REQUEST BLOOD
    // =========================================================

    static void requestBlood() {

        System.out.println();
        System.out.println("=============== BLOOD REQUEST ===============");

        System.out.print("Enter Patient Name: ");
        String patientName = scanner.nextLine().trim();

        System.out.print("Enter Required Blood Group: ");
        String bloodGroup = scanner.nextLine().trim().toUpperCase();

        if (!isValidBloodGroup(bloodGroup)) {

            System.out.println("\nInvalid blood group!");
            return;
        }

        int requiredUnits = readInteger("Enter Required Units: ");

        if (requiredUnits <= 0) {

            System.out.println("\nUnits must be greater than 0.");
            return;
        }

        // Search for blood group
        for (BloodStock stock : bloodStock) {

            if (stock.bloodGroup.equals(bloodGroup)) {

                // Enough blood available
                if (stock.units >= requiredUnits) {

                    stock.units -= requiredUnits;
                    saveStockToFile(); // Save updated stock to text file

                    System.out.println();
                    System.out.println("********************************************");
                    System.out.println("        BLOOD REQUEST APPROVED!");
                    System.out.println("********************************************");

                    System.out.println("Patient Name       : " + patientName);
                    System.out.println("Blood Group        : " + bloodGroup);
                    System.out.println("Units Given        : " + requiredUnits);
                    System.out.println("Remaining Stock    : " + stock.units);

                    return;
                }

                // Not enough blood
                else {

                    System.out.println();
                    System.out.println("Blood request cannot be fulfilled.");
                    System.out.println("Available Units : " + stock.units);
                    System.out.println("Required Units  : " + requiredUnits);

                    return;
                }
            }
        }

        System.out.println();
        System.out.println("Blood group " + bloodGroup
                + " is currently unavailable.");
    }

    // =========================================================
    // FILE I/O HANDLING (FILE DATABASE)
    // =========================================================

    static void loadDataFromFiles() {
        // Load Donors
        File donorFile = new File(DONORS_FILE);
        if (donorFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(donorFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        Donor donor = Donor.fromFileString(line);
                        if (donor != null) donors.add(donor);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading donors file: " + e.getMessage());
            }
        }

        // Load Stock
        File stockFile = new File(STOCK_FILE);
        if (stockFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(stockFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        BloodStock stock = BloodStock.fromFileString(line);
                        if (stock != null) bloodStock.add(stock);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading stock file: " + e.getMessage());
            }
        } else {
            // Default initial stock if no file exists yet
            initializeDefaultBloodStock();
            saveStockToFile();
        }
    }

    static void saveDonorsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DONORS_FILE))) {
            for (Donor donor : donors) {
                writer.write(donor.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving donors to file: " + e.getMessage());
        }
    }

    static void saveStockToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STOCK_FILE))) {
            for (BloodStock stock : bloodStock) {
                writer.write(stock.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving stock to file: " + e.getMessage());
        }
    }

    static void initializeDefaultBloodStock() {
        bloodStock.add(new BloodStock("A+", 10));
        bloodStock.add(new BloodStock("A-", 5));
        bloodStock.add(new BloodStock("B+", 8));
        bloodStock.add(new BloodStock("B-", 4));
        bloodStock.add(new BloodStock("AB+", 6));
        bloodStock.add(new BloodStock("AB-", 3));
        bloodStock.add(new BloodStock("O+", 12));
        bloodStock.add(new BloodStock("O-", 5));
    }

    // =========================================================
    // VALIDATE BLOOD GROUP
    // =========================================================

    static boolean isValidBloodGroup(String bloodGroup) {

        return bloodGroup.equals("A+")
                || bloodGroup.equals("A-")
                || bloodGroup.equals("B+")
                || bloodGroup.equals("B-")
                || bloodGroup.equals("AB+")
                || bloodGroup.equals("AB-")
                || bloodGroup.equals("O+")
                || bloodGroup.equals("O-");
    }

    // =========================================================
    // READ INTEGER SAFELY
    // =========================================================

    static int readInteger(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
            }
        }
    }
}