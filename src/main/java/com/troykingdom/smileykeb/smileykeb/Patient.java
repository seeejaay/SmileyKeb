package com.troykingdom.smileykeb.smileykeb;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
public class Patient {
    private String firstName;
    private String lastName;
    private int birthDay;
    private String birthMonth;
    private int birthyear;
    private int contactNumber;
    private String uName;
    private Scanner scan;
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
    
    public String getUName(){
        return uName;
    }
    
    public void savePatientDetails() {
        String filePath = "PatientInfo/" + uName + ".txt";

        try {
            File file = new File(filePath);

            if (file.exists()) {
                System.out.println("Patient file already exists. Cannot overwrite.");
                return;  // Return without saving if the file already exists
            }
            try (FileWriter fw = new FileWriter(filePath)) {
                fw.write(getUName() + "\t" + getName() + "\t" + getbirthDay());
                // Add more details as needed
                System.out.println("Patient details saved to file.");
            }
        } catch (IOException e) {
            System.out.println("Error saving patient details: " + e.getMessage());
        }
    }
    
    public void saveUserName(){
        try {
           FileWriter fw = new FileWriter("UserName/usernames.txt");
           fw.write(getUName() + "\n");
           fw.close();
        }catch(IOException e){
            System.out.println("Error Storing UserName" + e);
        }
    }
    
    
    
}
