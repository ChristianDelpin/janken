package com.janken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Events {

    public static void log(String text) 
    {
        try {
            // Get or create the log file.
            File file = new File("janken.log");
            if (!file.exists()) 
                file.createNewFile();
          
            // Open the file in append mode.
            FileWriter writer = new FileWriter(file, true);
          
            // Write the text to the file.
            writer.write(text+'\n');
            writer.close();
        } 
        catch (IOException e) 
        {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
    public static boolean isAMove(String move)
    {
        move=move.toLowerCase();
        boolean verifiedMove;
        switch(move)
        {
            case "rock": case "1":
            case "paper": case "2":
            case "scissors": case "scissor": case "3":
                verifiedMove=true;
                break;
            default:
                verifiedMove=false;
                break;

        }
        return verifiedMove;
    }
}
