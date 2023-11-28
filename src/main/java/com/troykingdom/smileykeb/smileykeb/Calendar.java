/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.troykingdom.smileykeb.smileykeb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Calendar {
    private String[] dateStatus = new String[30];
    
        public Calendar() {
        for (int i = 0; i < dateStatus.length; i++) {
            dateStatus[i] = String.valueOf(i + 1); 
        }
    }
         public void selectDate() {
        Scanner sc = new Scanner(System.in);

        try {
            FileReader fr = new FileReader("Calendar.txt");
            Scanner scan = new Scanner(fr);

            StringBuilder content = new StringBuilder();

            for (int i = 0; scan.hasNextLine(); i++) {
                content.append(scan.nextLine());
                if ((i + 1) % 7 == 0) {
                    content.append("\n"); 
                } else {
                    content.append("\t"); 
                }
            }

            System.out.println("Current Calendar:");
            System.out.println(content.toString());

            // user input for date to mark as occupied
            System.out.print("\nInsert Date to mark as 'OC': ");
            String dateIn = sc.nextLine();

            boolean alreadyOccupied = false;
            for (int i = 0; i < dateStatus.length; i++) {
                if (dateStatus[i].equals(dateIn) && dateStatus[i].equals("OC")) {
                    alreadyOccupied = true;
                    break;
                }
            }

            // update the calendar based on user input
            if (!alreadyOccupied) {
                for (int i = 0; i < dateStatus.length; i++) {
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
                for (int i = 0; i < dateStatus.length; i++) {
                    fw.write(dateStatus[i] + "\n"); 
                }
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }

            scan.close();
        } catch (IOException e) {
            System.out.println("Error Occurred: " + e.getMessage());
        }
    }
    }