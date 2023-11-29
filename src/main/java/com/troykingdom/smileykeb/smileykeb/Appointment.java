package com.troykingdom.smileykeb.smileykeb;
import static com.troykingdom.smileykeb.smileykeb.SmileyKeb.Appointment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// @author Malabanan, Palma, Bay, Vinas

public class Appointment{
    Treatment trCh = new CheckUp();
    Treatment trCl = new Cleaning();
    Treatment trEx = new Extraction();
    Treatment trFi = new Fillings();
    Treatment trRc = new RootCanal();
    private String treatmenttype;
    private String uName;
    private String date;
    
    public void setUname(String uName){
        this.uName= uName;
    }
    
    public void setDate (String date){
        this.date= date;
    }
    
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
        System.out.println("-----------------------------");
        
        System.out.print("Enter treatment choice: ");
        int treatmentChoice = scan.nextInt();
        scan.nextLine();
        System.out.println("-----------------------------");
        
        switch(treatmentChoice){
            case 1:
                setTreatment("Check-Up");
                setDate(cd.selectDate());
                trCh.performAppointment();
                break;
            case 2:
                setTreatment("Cleaning");
                setDate(cd.selectDate());
                trCl.performAppointment();
                break;
            case 3:
                setTreatment("Fillings");
                setDate(cd.selectDate());
                trFi.performAppointment();
                break;
            case 4: 
                setTreatment("Root Canal");
                setDate(cd.selectDate());
                trRc.performAppointment();
                break;
            case 5:
                setTreatment("Extraction");
               setDate(cd.selectDate());
                trEx.performAppointment();
                break;
            case 6:
                SmileyKeb.Appointment(scan);
                break;
            default:
                bookAppointment(scan);
                break;
        }
        
        savePatientHistory(treatmenttype);
        System.out.print("Return to Menu?[Y/N]: ");
        choice = scan.nextLine();

        choice = choice.toUpperCase();
        } while("N".equals(choice) || "NO".equals(choice));
           Appointment(scan);
    }
    
    public void savePatientHistory(String treatment){
            System.out.println("Appointment booked for user: " + uName);
            System.out.println("Treatment: " + treatment);
            System.out.println("Date: " + date);
            System.out.println();
            saveToFile();
    }
    
    public void openHistory(Scanner scan){
        try {
            String filepath = "PatientHistory/" + uName + ".txt";
            FileReader fr = new FileReader(filepath);
            Scanner scanner = new Scanner(fr);
            StringBuilder content = new StringBuilder();
            // read each line of the file and append it to the content
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }   scanner.close();
            System.out.println(content.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Error Occured: " + e.getMessage() );
        }
        SmileyKeb.menu(scan);
    }
    
    public void saveToFile(){
        try {
            String filepath = "PatientHistory/" + uName + ".txt";
            FileWriter fw = new FileWriter(filepath,true);
            fw.write( "DATE: " +date+ ", " + "TREATMENT: " +getTreatment()+ "\n");
            fw.close();
        } catch  (IOException e){
            System.out.println("Error Occured: " + e.getMessage());
        }
    }
    
    private void setTreatment(String treatment){
        this.treatmenttype = treatment;
    }
    
    private String getTreatment(){
        return treatmenttype;
    }
    
    public void cancelAppointment(Scanner scan){
        System.out.print("Enter date of appointment to cancel: ");
        int cancel = scan.nextInt();
        scan.nextLine();
        String removed = String.valueOf(cancel);
        
        try {
            String filepath = "PatientHistory/" + uName + ".txt";
            String tempFile = "temp.txt";
            File oldFile = new File(filepath);
            File newFile = new File(tempFile);

            String currentLine;
            String items[];

            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            int lineNumber = 0;
            boolean found = false;

            while ((currentLine = br.readLine()) != null) {
                items = currentLine.split(", ");
                lineNumber++;

                if (items.length > 0 && items[0].equalsIgnoreCase("DATE: " + removed)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Appointment not found for date: " + removed);
                SmileyKeb.menu(scan);
            }

            br.close();
            fr.close();
            fr = new FileReader(filepath);
            br = new BufferedReader(fr);

            for (int i = 0; i < lineNumber - 1; i++) {
                currentLine = br.readLine();
                pw.println(currentLine);
            }

            br.readLine();

            while ((currentLine = br.readLine()) != null) {
                pw.println(currentLine);
            }

            pw.flush();
            pw.close();
            br.close();
            fr.close();
            bw.close();
            fw.close();

            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);

            System.out.println("Appointment canceled for date: " + removed);
            Calendar calendar = new Calendar();
            calendar.freeUpDate(removed);
            
        } catch (IOException e) {
            System.out.println("Error Occured: " + e.getMessage());
        }
        SmileyKeb.menu(scan);
    }
 }