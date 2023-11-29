package com.troykingdom.smileykeb.smileykeb;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// @author Malabanan, Palma, Bay, Vinas

public class Patient {
    private String firstName;
    private String lastName;
    private int birthDay;
    private String birthMonth;
    private int birthyear;
    private long contactNumber;
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
        String bday = birthMonth + "/" + birthDay+ "/" + birthyear; 
        return bday;
    }
    
    public long getconNumber(){
        return contactNumber;
    }
    
    public void setUName(){
        String userName = firstName.charAt(0) +lastName + String.valueOf(birthyear);
        this.uName = userName;
    }
    
    public void setUName(String userName){
        this.uName = userName;
    }
    
    public void setcontactNum(long contactNumber ){
        this.contactNumber = contactNumber;
    }
    
    public long getcontactNum(){
        return contactNumber;
    }
    
    public String getUName(){
        return uName;
    }
    
    public void savePatientDetails() {
        saveName();
        saveContactNum();
        saveBirthDay();
        saveUserName();
        createUserFile();
        System.out.println("Patient details saved to file");
    }
    
    public void saveName(){
        try {
            String filepath = "PatientInfo/names" +  ".txt";
            try(FileWriter fw = new FileWriter(filepath,true)){
                fw.write(getName() + "\n" );
                fw.close();
            }
        } catch (IOException e){
            System.out.println("Error saving patient details: " + e.getMessage());   
        }
    }
    
    public void saveContactNum(){
        String contactNum = Long.toString(contactNumber);
        System.out.println(contactNum);
        try {
            String filepath = "PatientInfo/contactnumber" +".txt";
            try(FileWriter fw = new FileWriter(filepath,true)){
                fw.write(contactNum + "\n" );
                fw.close();
            }
        } catch (IOException e){
            System.out.println("Error saving patient details: " + e.getMessage());   
        }
    }
    
    public void saveBirthDay(){
        try{
            String filepath = "PatientInfo/birthday" +".txt";
            try(FileWriter fw = new FileWriter(filepath,true)){
                fw.write(getbirthDay() + "\n" );
                fw.close();
            }
        } catch (IOException e){
            System.out.println("Error saving patient details: " + e.getMessage());   
        }
    }
    
    public void saveUserName(){
        try {
            String filepath = "PatientInfo/usernames.txt";
            try (FileWriter fw = new FileWriter(filepath, true)) {
                fw.write(getUName() + "\n");
                fw.close();
            }
        } catch (IOException e) {
            System.out.println("Error storing Username: " + e.getMessage());
        }
    }
    
    public void createUserFile(){
        try {
            String filepath = "PatientHistory/" + getUName() + ".txt";
            File file = new File(filepath);
            file.createNewFile();
        } catch (IOException e){
            System.out.println("Error creating File: " + e.getMessage());
        }
    }
    
    public static boolean checkUNameDuplicate(String username) {
        try {
            File file = new File("PatientInfo/usernames.txt");
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