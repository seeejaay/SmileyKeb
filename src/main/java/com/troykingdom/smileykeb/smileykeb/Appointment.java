package com.troykingdom.smileykeb.smileykeb;
import static com.troykingdom.smileykeb.smileykeb.SmileyKeb.menu;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

// @author Malabanan, Palma, Bay, Vinas

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

                SmileyKeb.menu(scan);
                break;
            default:
                bookAppointment(scan);
                break;
        }
        System.out.print("Return to Menu?[Y/N]:");
        choice = scan.nextLine();

        choice = choice.toUpperCase();
        } while("N".equals(choice) || "NO".equals(choice));
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
    
    public void openHistory(Scanner scan){
        FileReader fr = null;
        try {
            String uName;
            System.out.print("Enter Username: ");
            uName = scan.nextLine();
            String filepath = "PatientHistory/" + uName + ".txt";
            fr = new FileReader(filepath);
            Scanner scanner = new Scanner(fr);
            StringBuilder content = new StringBuilder();
            // read each line of the file and append it to the content
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }   scanner.close();
            System.out.println(content.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Error Occured: " + e.getMessage() );
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                 System.out.println("Error Occured: " + e.getMessage() );
            }
        }
    }
 }