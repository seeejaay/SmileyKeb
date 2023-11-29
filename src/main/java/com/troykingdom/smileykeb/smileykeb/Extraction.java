package com.troykingdom.smileykeb.smileykeb;

public class Extraction implements Treatment{
    private String tr = "Extraction";
    
    @Override
    public void performAppointment() {
        System.out.println("\tAppointment chosen: Extraction...");
        System.out.println();
    }
    
    @Override
    public String getTreatment(){
        return tr;
    }
}
