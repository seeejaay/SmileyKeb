package com.troykingdom.smileykeb.smileykeb;

public class CheckUp implements Treatment{
    @Override
    public void performAppointment() {
        System.out.println("\tAdditional process: Check-Up");
        System.out.println();
    }
}
