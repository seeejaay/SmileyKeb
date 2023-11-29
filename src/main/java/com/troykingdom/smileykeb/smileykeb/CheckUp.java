package com.troykingdom.smileykeb.smileykeb;

public class CheckUp implements Treatment{
    private String tr = "Check-Up";
    @Override
    public void performAppointment() {
        System.out.println("\tAdditional process: Check-Up");
        System.out.println();
    }
    
    @Override
    public String getTreatment(){
        return tr;
    }
}
