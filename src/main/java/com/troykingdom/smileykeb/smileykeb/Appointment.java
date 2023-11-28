package com.troykingdom.smileykeb.smileykeb;
import static com.troykingdom.smileykeb.smileykeb.SmileyKeb.Appointment;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Appointment{
    
    static void bookAppointment(Scanner scan) {
        System.out.println("\nTREATMENTS AVAILABLE:");
        System.out.println("[1] Check-up");
        System.out.println("[2] Cleaning");
        System.out.println("[3] Fillings");
        System.out.println("[4] Root Canal");
        System.out.println("[5] Extraction");
        System.out.println("[6] Back to Menu");
        System.out.println("----------------------------");
        
        System.out.print("Enter treatment choice: ");
        int treatmentChoice = scan.nextInt();
        scan.nextLine();
        
        String treatment = getTreatmentName(treatmentChoice);
        
        if (treatmentChoice == 6){
            System.out.println("Returning to menu...");
            Appointment(scan);
        }
        
        switch (treatmentChoice) {
            case 1:
                new CheckUp().performAppointment();
                break;
            case 2:
                new Cleaning().performAppointment();
                break;
            case 3:
                new Fillings().performAppointment();
                break;
            case 4:
                new RootCanal().performAppointment();
                break;
            case 5:
                new Extraction().performAppointment();
                break;
            default:
                System.out.println("Invalid treatment choice");
        }
        // date class 
        Patient patient = new Patient();
        savePatientInfo(patient, treatment);
    }
    
    private static void savePatientInfo(Patient patient, String treatment) {
    String fileName = patient.getUName() + ".txt";

    try (FileWriter fw = new FileWriter(fileName)) {
        fw.write("USERNAME: " + "\n" + patient.getUName() + "\t\t" +
                "NAME: " + "\n" + patient.getName() + "\t\t" +
                "BIRTHDAY: " + "\n" + patient.getbirthDay() + "\t\t" +
                "CONTACT NUMBER: " + "\n" + patient.getconNumber() + "\t\t" +
                "TREATMENT: " + "\n" + treatment);

        System.out.println();
        System.out.println("Appointment booked for: " + patient.getName());
        System.out.println("Username: " + patient.getUName());
        System.out.println("Treatment: " + treatment);
    } catch (IOException e) {
        System.out.println("Error writing to file: " + e.getMessage());
    }
}
    
    static void openAppointment(Scanner scan) {
        System.out.println("\nOPEN EXISTING APPOINTMENT:");
        System.out.println("Hint: First letter of firstname, lastname and birthyear {ex: LPalma2007)");
        System.out.print("Enter username: ");
        String username = scan.nextLine();

        String folderPath = "PatientHistory";
        String fileName = folderPath + "/" + username + ".txt";

        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            if (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split("\t");

                System.out.println("\nPatient " + username + " Information");
                for (String item : data) {
                    System.out.println(item);
                }
            } else {
                System.out.println("No patient information found for username: " + username);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
}
    
    static void cancelAppointment(Scanner scan) {
        System.out.println("\nCANCEL APPOINTMENT:");
        System.out.println("Hint: First letter of firstname, lastname and birthyear {ex: LPalma2007)");
        System.out.print("Enter username to cancel: ");
        String username = scan.nextLine();

        String folderPath = "PatientHistory/" + username;
        String fileName = folderPath + "/" + username + ".txt";

        File file = new File(fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Appointment for user: " + username + " has been canceled.");
            } else {
                System.out.println("Failed to cancel the appointment. Please try again.");
            }
        } else {
            System.out.println("No appointment found for username: " + username);
        }
    }
    
    private static String getTreatmentName(int choice) {
        switch (choice) {
            case 1:
                return "Cleaning";
            case 2:
                return "Extraction";
            case 3:
                return "Fillings";
            case 4:
                return "Root Canal";
            case 5:
                return "Brace Adjustments";
            case 6:
                return "Braces";
            case 7:
                return "Check-up";
            default:
                return "Unknown Treatment";
        }
    }
}
class Cleaning extends Appointment {
    public void performAppointment() {
        System.out.println("\tAppointment chosen: Cleaning...");
        System.out.println();
    }
}
class CheckUp extends Appointment {
    public void performAppointment() {
        System.out.println("\tAdditional process: Check-Up");
        System.out.println();
    }
}
class Fillings extends Appointment {
    public void performAppointment() {
        System.out.println("\tAppointment chosen: Fillings...");
        System.out.println();
    }
}
class RootCanal extends Appointment {
    public void performAppointment() {
        System.out.println("\tAppointment chosen: RootCanal...");
        System.out.println();
    }
}
class Extraction extends Appointment {
    public void performAppointment() {
        System.out.println("\tAppointment chosen: Extraction...");
        System.out.println();
    }
}