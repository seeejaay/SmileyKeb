package com.troykingdom.smileykeb.smileykeb;

public class RootCanal implements Treatment{
    private String tr = "Root Canal";
    @Override
     public void performAppointment() {
        System.out.println("\tAppointment chosen: RootCanal...");
        System.out.println();
    }
    
    @Override
    public String  getTreatment(){
         return tr;
    }
     
}
