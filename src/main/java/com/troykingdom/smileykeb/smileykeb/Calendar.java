package com.troykingdom.smileykeb.smileykeb;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// @author Malabanan, Palma, Bay, Vinas
 
public class Calendar {
    private final String[] dateStatus;

    public Calendar() {
        this.dateStatus = new String[30];
        for (int i = 0; i < dateStatus.length; i++) {
            dateStatus[i] = String.valueOf(i + 1);
        }
    }

    public String selectDate() {
        for (int i = 0; i < dateStatus.length; i++) {
            dateStatus[i] = String.valueOf(i + 1); 
        }
        String dateIn = null;
    Scanner sc = new Scanner(System.in);

    try {
       FileReader fr = new FileReader("Calendar.txt");
        Scanner scan = new Scanner(fr);

        StringBuilder content = new StringBuilder();

        int i = 0;
        while (scan.hasNextLine()) {
            dateStatus[i] = scan.nextLine();
            content.append(dateStatus[i]);

            if ((i + 1) % 7 == 0) {
                content.append("\n");
            } else {
                content.append("\t");
            }
            i++;
        }

        System.out.println("Current Calendar:");
        System.out.println(content.toString());
        
        // user input for date to mark as occupied
        System.out.print("\nInsert Date to mark as 'OC': ");
         dateIn = sc.nextLine();
        
        Appointment apt = new Appointment();
        apt.setDate(dateIn);
        boolean alreadyOccupied = false;
        for ( i = 0; i < dateStatus.length; i++) {
            if (dateStatus[i].equals(dateIn) && dateStatus[i].equals("OC")) {
                alreadyOccupied = true;
                break;
            }
        }

        // update the calendar based on user input
        if (!alreadyOccupied) {
            for (i = 0; i < dateStatus.length; i++) {
                if (dateStatus[i].equals(dateIn)) {
                    dateStatus[i] = "OC"; 
                    System.out.println("Date selected: " + dateIn + " marked as 'OC'.");
                }
            }
        } else {
            System.out.println("Date " + dateIn + " is already marked as 'OC'.");
        }

        // write the updated data back to the file
        try (FileWriter fw = new FileWriter("Calendar.txt")) {
            for ( i = 0; i < dateStatus.length; i++) {
                fw.write(dateStatus[i] + "\n"); 
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        scan.close();
    } catch (IOException e) {
        System.out.println("Error Occurred: " + e.getMessage());
    }
     
    return dateIn;
       
    }
    
    public void markDateAsOccupied(String dateIn) {
        for (int i = 0; i < dateStatus.length; i++) {
            if (dateStatus[i].equals(dateIn) && !dateStatus[i].equals("OC")) {
                dateStatus[i] = "OC";
                System.out.println("Date selected: " + dateIn + " marked as 'OC'.");
            }
        }

        // write the updated data back to the file
        try (FileWriter fw = new FileWriter("Calendar.txt")) {
            for (String dateStatu : dateStatus) {
                fw.write(dateStatu + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void freeUpDate(String canceledDate) {
        for (int i = 0; i < dateStatus.length; i++) {
            if (dateStatus[i].equals("OC") && dateStatus[i].equals(canceledDate)) {
                dateStatus[i] = String.valueOf(i + 1);
                System.out.println("Date " + canceledDate + " freed up.");
                break;  // assuming only one occurrence needs to be freed up
            }
        }

        // write the updated data back to the file
        try (FileWriter fw = new FileWriter("Calendar.txt")) {
            for (String dateStatu : dateStatus) {
                fw.write(dateStatu + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
