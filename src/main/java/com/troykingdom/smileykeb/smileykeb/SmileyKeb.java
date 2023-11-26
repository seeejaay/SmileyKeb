package com.troykingdom.smileykeb.smileykeb;
import java.util.Scanner;
 
public class SmileyKeb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Appointment apt = new Appointment();
        int choice;
        do{
            System.out.println("\n------------MENU------------");
            System.out.println("[1] Book Appointment");
            System.out.println("[2] Open Existing Appointment");
            //System.out.println("[3] Cancel Appointment");
            System.out.println("[3] Exit");
            System.out.println("----------------------------");
            
            System.out.print("Enter choice: ");
            choice = scan.nextInt();
            scan.nextLine();
            System.out.println("----------------------------");
            
            switch(choice){
                case 1:
                    apt.bookAppointment(scan);
                    break;
                case 2:
                    apt.openAppointment(scan);
                    break;
                /*case 3:
                    apt.cancelAppointment(scan);
                    break;*/
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice. Kindly enter again.");
            }
        }while (choice >= 1 && choice <= 3);
    }
}
