package com.troykingdom.smileykeb.smileykeb;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class SmileyKeb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
            menu(scan);
    }
    
    public static void menu(Scanner scan){
        int inp;
        System.out.println("Welcome to SmileyKeb Dental Clinic\n");
        
        System.out.println("------------MENU------------");
        System.out.println("[1] Login");
        System.out.println("[2] SignUp");
        System.out.println("[3] Exit");
        System.out.print("Choice: ");
        inp = scan.nextInt();
        scan.nextLine();
        
        switch(inp){
            case 1: 
                Login(scan);
            break;
            case 2:
                signUp(scan);
            break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid Input");
                menu(scan);
                break;
        }
    }
    
    public static void Login(Scanner scan){
        String uName;
        
        System.out.println("Hint: First letter of lastname and birthyear");
        System.out.print("Enter your username: ");
        uName = scan.nextLine();
        File file = new File("PatientInfo/"+uName + ".txt");
        if (file.exists()) {
            System.out.println("Login Successful!");
            Appointment(scan);
            // You can read the file to get patient details if needed
        } else {
            System.out.println("Username not found. Please sign up.");
            menu(scan);
        }
        
    }
    
    public static void signUp(Scanner scan){
        
        Patient newPat = new Patient();
        
        System.out.print("Enter your FirstName: ");
        newPat.setFName(scan.nextLine());
        
        System.out.print("Enter your Last Name: ");
        newPat.setLname(scan.nextLine());
        
        System.out.print("Enter your BirthDate: ");
        newPat.setbirthDay(scan.nextInt());
        
        scan.nextLine();
        System.out.print("Enter your BirthMonth: ");
        newPat.setbirthMonth(scan.nextLine());
        
        System.out.print("Enter your BirthYear: ");
        newPat.setbirthYear(scan.nextInt());
        scan.nextLine();
        newPat.setUName();//fixed calling of setUName, becaues it was unreachable
        if (checkUNameDuplicate(newPat.getUName())) {
            System.out.println("Username already exists. Please choose another clinic :D"); // di ko alam irreturn haha
            menu(scan);
        } else {
            //former location of setUName
            System.out.println("Your username is " + newPat.getUName() + "\n");
            newPat.savePatientDetails();
            newPat.saveUserName();
            menu(scan);
        }
    }
    //will put this method to Patient class later - Carl
    private static boolean checkUNameDuplicate(String username) {
    try {
        File file = new File("UserName/usernames.txt");
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.equals(username)) {
                return true; // username already exists
            }
        }
        scan.close();
    } catch (FileNotFoundException e) {
        System.out.println("Error checking username duplicates: " + e.getMessage());
    }
    return false; // username does not exist
}
    
    public static void Appointment(Scanner scan){
            Appointment apt = new Appointment();
            System.out.println("\n------------MENU------------");
            System.out.println("[1] Book Appointment");
            System.out.println("[2] Open Existing Appointment");
            //System.out.println("[3] Cancel Appointment");
            System.out.println("[3] Exit");
            System.out.println("----------------------------");
            
            System.out.print("Enter choice: ");
            int choice = scan.nextInt();
            scan.nextLine();
            System.out.println("----------------------------");
            
            switch(choice){
                case 1:
                    apt.bookAppointment(scan);
                    break;
                case 2:
                    apt.openAppointment(scan);
                    break;
                case 3:
                    //apt.cancelAppointment(scan);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice. Kindly enter again.");
                    Appointment(scan);
                    
            }
    }
}