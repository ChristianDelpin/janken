package com.janken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public static class Score {
    /**
     * Method to get, update, and/or display the highest score.
     * 
     * @param isNewHighScore Boolean variable that will determine whether to overwrite the highscore file or to display the high score.
     */
    static void displayHighScore(boolean isNewHighScore)
    {

        try {
            File scoreTxt = new File("highscore.txt");
            if (scoreTxt.exists()) 
            {
              //File exists. 

              //Delete file if overwrite no worky??
            } 
            else 
            {
              //File does not exist.

              scoreTxt.createNewFile();
              
              FileWriter writer = new FileWriter(scoreTxt.getName());
              writer.write("");
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

        if(isNewHighScore)
        {
            //Updates high score and displays new score.
            //System.out.println();

            String name = scanner.nextLine();
            
        }
        else
        {
            //Displays current high score
        }
    }    
}
