package com.troykingdom.smileykeb.smileykeb;

public class Cleaning implements Treatment {
    private String tr = "Cleaning";
    
    @Override
    public void performAppointment() {
        System.out.println("\tAppointment chosen: Cleaning...");
        System.out.println();
    }
    
    @Override
    public String getTreatment(){
        return tr;
    }

}
