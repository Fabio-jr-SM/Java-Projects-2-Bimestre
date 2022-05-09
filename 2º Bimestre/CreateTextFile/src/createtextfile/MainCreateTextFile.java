package com.deitel.ch17;
public class MainCreateTextFile {
    public static void main(String[] args){
        CreateTextFile application = new CreateTextFile();
    
        application.openFile();
        application.addRecords();
        application.closeFile();
    }
}
