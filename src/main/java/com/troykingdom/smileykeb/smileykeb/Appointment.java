package com.troykingdom.smileykeb.smileykeb;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Appointment{
    private static int uidCounter = 1; 
    
    static void bookAppointment(Scanner scan) {
        System.out.println("\nTREATMENTS AVAILABLE:");
        System.out.println("[1] Cleaning");
        System.out.println("[2] Extraction");
        System.out.println("[3] Fillings");
        System.out.println("[4] Root Canal");
        System.out.println("[5] Brace Adjustments");
        System.out.println("[6] Braces");
        System.out.println("[7] Check-up");
        System.out.println("[8] Back to Menu");
        System.out.println("----------------------------");
        
        System.out.print("Enter treatment choice: ");
        int treatmentChoice = scan.nextInt();
        scan.nextLine();
        
        if (treatmentChoice == 8) {
            System.out.println("Returning to Main Menu...");
            return;
        }

        String treatment = getTreatmentName(treatmentChoice);

        System.out.print("Enter First Name: ");
        String fName = scan.nextLine();
        
        System.out.print("Enter Last Name: ");
        String lName = scan.nextLine();
        
        System.out.print("Enter Age: ");
        int age = scan.nextInt();
        
        System.out.print("Enter Contact Number: ");
        int contactNum = scan.nextInt();

        int uid = uidCounter++;
        savePatientInfo(uid, fName, lName, age, contactNum, treatment);
    }
    
    private static void savePatientInfo(int uid, String fName, String lName, int age, int contactNum, String treatment) {
        String fileName = "Patient #" + uid + ".txt";

        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write("UID: " + uid + "\t" + 
                    "NAME: " + fName + " " + lName + "\t" + 
                    "AGE: " + age + "\t" + 
                    "CONTACT NUMBER: " + contactNum + "\t" + 
                    "TREATMENT: " + treatment);
            
            System.out.println();
            System.out.println("Appointment booked for: " + fName + " " + lName);
            System.out.println("UID: #" + uid);
            System.out.println("Treatment: " + treatment);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            //return main;
        }
    }
    
    static void openAppointment(Scanner scan) {
        System.out.println("\nOPEN EXISTING APPOINTMENT:");
        System.out.print("Enter UID: ");
        String apptID = scan.nextLine();

        String fileName = "Patient #" + apptID + ".txt";

        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            if (fileScanner.hasNextLine()) {
                String[] data = fileScanner.nextLine().split("\t");

                System.out.println("\nPatient #" + apptID + " Information");
                for (String item : data) {
                System.out.println(item);
            }
            } else {
                System.out.println("No patient information found for appointment ID: " + apptID);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
    
    //add break sequence
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
