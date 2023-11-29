package com.troykingdom.smileykeb.smileykeb;

public class Fillings implements Treatment{
      private String tr = "Fillings";
     @Override
     public void performAppointment() {
        System.out.println("\tAppointment chosen: Fillings...");
        System.out.println();
    }
     
     @Override
     public String getTreatment(){
        return tr;
     }
}
