package com.troykingdom.smileykeb.smileykeb;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
*   author Bay,Malabanan,Palma,Vinas
*/

public class Patient {
    private String firstName;
    private String lastName;
    private int birthDay;
    private String birthMonth;
    private int birthyear;
    private int contactNumber;
    private String uName;
    public void setFName(String fName){
        this.firstName = fName;
    }
    
    public void setLname (String lName){
        this.lastName = lName;
    }
    
    public void setbirthDay(int bDay){
        this.birthDay = bDay;
    }
    
    public void setbirthMonth(String bMonth){
        this.birthMonth = bMonth;
    }
    
    public void setbirthYear(int bYear){
        this.birthyear = bYear;
    }
    
    public String getName(){
        return firstName + " " + lastName;
    }
    
    public String getbirthDay(){
        String bday = birthMonth + " " + birthDay+ " " + birthyear; 
        return bday;
    }
    
    public int getconNumber(){
        return contactNumber;
    }
    
    public void setUName()
    {
        String userName = firstName.charAt(0) +lastName + String.valueOf(birthyear);
        
        this.uName = userName;
    }
    
    public void setUName(String userName){
        this.uName = userName;
    }
    
    public String getUName(){
        return uName;
    }
    
    public void savePatientDetails() {
        
        try{
            String filepath = "PatientInfo/" + getUName() + ".txt";
            try(FileWriter fw = new FileWriter(filepath)){
                fw.write(getUName() + "\t" + getName() + "\t" + getbirthDay());
                saveUserName();
                System.out.println("Patient details saved to file");
            }
        }catch (IOException e){
            System.out.println("Error saving patient details: " + e.getMessage());   
        }
        
    }
    
    public void saveUserName(){
        
        try {
            String filepath = "Username/usernames.txt";
            try (FileWriter fw = new FileWriter(filepath, true)) {
                fw.write(getUName() + "\n");
                System.out.println("Username stored successfully.");
                fw.close();
            }
        } catch (IOException e) {
            System.out.println("Error storing Username: " + e.getMessage());
        }
    }
    
    public static boolean checkUNameDuplicate(String username) {
        try {
            File file = new File("UserName/usernames.txt");
            try (Scanner scan = new Scanner(file)) {
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    if (line.equals(username)) {
                        return true; // username already exists
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error checking username duplicates: " + e.getMessage());
        }
        return false; // username does not exist
    }

}
