package com.troykingdom.smileykeb.smileykeb;

import java.io.File;
import java.io.IOException;


public class FileCreation {
    public static void createFiles(){
        try{
            File dir = new File("PatientHistory");
                if(!dir.exists()){
                dir.mkdirs();
                }
           
            File dir1 = new File("PatientInfo");
            if (!dir1.exists()) {
                dir1.mkdirs();
            }
            File file1 = new File(dir1, "usernames.txt");
            file1.createNewFile();
            
            File file2 = new File(dir1,"names.txt");
            file2.createNewFile();
            
            File file3 = new File(dir1,"birthday.txt");
            file3.createNewFile();
            
            File file4 = new File(dir1,"contactnumber.txt");
            file4.createNewFile();

        }catch(IOException e){
        }
        
    }
}
