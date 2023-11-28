package com.troykingdom.smileykeb.smileykeb;
import static com.troykingdom.smileykeb.smileykeb.SmileyKeb.menu;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Appointment{
    
    Treatment trCh = new CheckUp();
    Treatment trCl = new Cleaning();
    Treatment trEx = new Extraction();
    Treatment trFi = new Fillings();
    Treatment trRc = new RootCanal();
    
    public void bookAppointment(Scanner scan){
        Calendar cd = new Calendar();
        String choice;
        do{
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
        
        
        
            switch(treatmentChoice){
                case 1:
                    cd.selectDate();
                    trCh.performAppointment();
                    break;
                case 2:
                    cd.selectDate();
                    trCl.performAppointment();
                    break;
                case 3:
                    cd.selectDate();
                    trFi.performAppointment();
                    break;
                case 4: 
                    cd.selectDate();
                    trRc.performAppointment();
                    break;
                case 5:
                    cd.selectDate();
                    trEx.performAppointment();
                    break;
                case 6:
                    cd.selectDate();
                    SmileyKeb.menu(scan);
                    break;
                default:
                    bookAppointment(scan);
                    break;
            }
            System.out.print("Return to Menu?[Y/N]:");
            choice = scan.nextLine();
            
            choice = choice.toUpperCase();
        }while("N".equals(choice) || "NO".equals(choice));
           menu(scan);
    }
    
    public void savePatientHistory(String treatment){
            Patient newPat = new Patient();
            String fileName = "PatientHistory/" + newPat.getUName() + ".txt";

        try (FileWriter fw = new FileWriter(fileName)){
            fw.write("TREATMENT TYPE: " + treatment);
            System.out.println();
            System.out.println("Appointment booked for: " + newPat.getName());
            System.out.println("Username: " + newPat.getUName());
            System.out.println("Treatment: " + treatment);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    
//    static String bookAppointment(Scanner scan) {
//        System.out.println("\nTREATMENTS AVAILABLE:");
//        System.out.println("[1] Check-up");
//        System.out.println("[2] Cleaning");
//        System.out.println("[3] Fillings");
//        System.out.println("[4] Root Canal");
//        System.out.println("[5] Extraction");
//        System.out.println("[6] Back to Menu");
//        System.out.println("----------------------------");
//        
//        System.out.print("Enter treatment choice: ");
//        Patient newPat = new Patient();
//        int treatmentChoice = scan.nextInt();
//        scan.nextLine();
//        
//        String treatment = getTreatmentName(treatmentChoice);
//        
//        switch (treatmentChoice) {
//            case 1:
//                new CheckUp().performAppointment();
//                break;
//            case 2:
//                new Cleaning().performAppointment();
//                break;
//            case 3:
//                new Fillings().performAppointment();
//                break;
//            case 4:
//                new RootCanal().performAppointment();
//                break;
//            case 5:
//                new Extraction().performAppointment();
//                break;
//            default:
//                System.out.println("Invalid treatment choice");
//        }
//        // date class 
//        Patient patient = new Patient();
//        savePatientInfo(treatment);
//        return null;
//    }
//    
//    public static void savePatientInfo(String treatment) {
//    Patient newPat = new Patient();
//    String fileName = newPat.getUName() + ".txt";
//
//    try (FileWriter fw = new FileWriter(fileName)) {
//        fw.write("USERNAME: " + "\n" + newPat.getUName() + "\t\t" +
//                "NAME: " + "\n" + newPat.getName() + "\t\t" +
//                "BIRTHDAY: " + "\n" + newPat.getbirthDay() + "\t\t" +
//                "CONTACT NUMBER: " + "\n" + newPat.getconNumber() + "\t\t" +
//                "TREATMENT: " + "\n" + treatment);
//
//        System.out.println();
//        System.out.println("Appointment booked for: " + newPat.getName());
//        System.out.println("Username: " + newPat.getUName());
//        System.out.println("Treatment: " + treatment);
//    } catch (IOException e) {
//        System.out.println("Error writing to file: " + e.getMessage());
//    }
//}
//    
//    public static void openAppointment(Scanner scan) {
//        System.out.println("\nOPEN EXISTING APPOINTMENT:");
//        System.out.print("Enter UID: ");
//        int apptID = scan.nextInt();
//
//        String fileName = "Patient #" + apptID + ".txt";
//
//        try {
//            Scanner fileScanner = new Scanner(new File(fileName));
//            if (fileScanner.hasNextLine()) {
//                String[] data = fileScanner.nextLine().split("\t");
//
//                System.out.println("\nPatient #" + apptID + " Information");
//                for (String item : data) {
//                System.out.println(item);
//            }
//            } else {
//                System.out.println("No patient information found for appointment ID: " + apptID);
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found: " + fileName);
//        }
//    }
//    
//    //add break sequence
//    private static String getTreatmentName(int choice) {
//        switch (choice) {
//            case 1:
//                return "Cleaning";
//            case 2:
//                return "Extraction";
//            case 3:
//                return "Fillings";
//            case 4:
//                return "Root Canal";
//            case 5:
//                return "Brace Adjustments";
//            case 6:
//                return "Braces";
//            case 7:
//                return "Check-up";
//            default:
//                return "Unknown Treatment";
//        }
//    }
}
