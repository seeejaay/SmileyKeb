package com.troykingdom.smileykeb.smileykeb;

import java.io.File;
import java.io.IOException;


public class FileCreation {
    public static void createFiles(){
        try{
            File dir = new File("PatientInfo");
                if(!dir.exists()){
                dir.mkdirs();
                }
           
            File dir1 = new File("UserName");
            if (!dir1.exists()) {
                dir1.mkdirs();
            }
            File file1 = new File(dir1, "usernames.txt");
            file1.createNewFile();
            
            
        }catch(IOException e){
        }
        
    }
}
