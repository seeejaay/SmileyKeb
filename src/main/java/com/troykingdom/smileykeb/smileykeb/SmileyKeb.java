package com.troykingdom.smileykeb.smileykeb;
import java.util.Scanner;
import java.io.File;
import java.util.InputMismatchException;

// @author Malabanan, Palma, Bay, Vinas

public class SmileyKeb {
    private static String uName;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
            menu(scan);
    }
    
    public static void menu(Scanner scan){
        int inp;
        boolean validInput = false;
        
        while(!validInput){
            try{
                System.out.println("Welcome to SmileyKeb Dental Clinic\n");

                System.out.println("------------MENU------------");
                System.out.println("[1] Login");
                System.out.println("[2] SignUp");
                System.out.println("[3] Exit");
                System.out.println("----------------------------");
                System.out.print("Enter Choice: ");
                inp = scan.nextInt();
                scan.nextLine();
                System.out.println("----------------------------");

                switch(inp){
                    case 1: 
                        validInput =true;
                        Login(scan);

                    break;
                    case 2:
                        validInput =true;
                        signUp(scan);
                    break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Invalid Input");

                        break;
                }

            } catch(Exception e){
                System.out.println("Error Occured: " + e.getMessage());
                scan.nextLine();
                menu(scan);
            }
        }
    }
    
    public static void Login(Scanner scan){
        
        Patient newPat = new Patient();
        System.out.println("Hint: First letter of firstname, lastname and birthyear (ex: LPalma2007)");
        System.out.print("Enter your username: ");
        uName = scan.nextLine();
        File file = new File("PatientHistory/"+uName + ".txt");
        if (file.exists()) {
            System.out.println("Login Successful!");
            newPat.setUName(uName);
            Appointment(scan);
            // you can read the file to get patient details if needed
        } else {
            System.out.println("Username not found. Please sign up.");
            menu(scan);
        }
    }
    
    public static void signUp(Scanner scan){
        try{
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
            
            System.out.print("Enter your Contact #: ");
            newPat.setcontactNum(scan.nextInt());
            scan.nextLine();
            
            newPat.setUName();
            FileCreation.createFiles();
            
            if (Patient.checkUNameDuplicate(newPat.getUName())) {
                System.out.println("Username already exists. Please call the clinic."); 
                menu(scan);
            } else {
                // former location of setUName
                System.out.println("Your username is " + newPat.getUName() + "\n");
                newPat.savePatientDetails();
                menu(scan);
            }
        } catch (InputMismatchException e){
            System.out.println("Error occured: " + e.getMessage());
            scan.nextLine();
            menu(scan);
        }
    }
    public static void Appointment(Scanner scan){
        Appointment apt = new Appointment();
        apt.setUname(uName);
        System.out.println("\n------------MENU------------");
        System.out.println("[1] Book Appointment");
        System.out.println("[2] Open Existing Appointment");
        System.out.println("[3] Cancel Appointment");
        System.out.println("[4] Exit");
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
               apt.openHistory(scan);
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