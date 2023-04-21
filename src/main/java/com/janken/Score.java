package com.janken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Score {


  static Scanner scanner = new Scanner(System.in);
  public static int currentScore;
  public static int allTimeHighsore;
  private static Path filePath;
  
    static void displayHighScore()
    {
      System.out.println("**********\nAll-time High Score: "+allTimeHighsore+"\nCurrent Score: "+currentScore+"\n**********");
    }

    static void setAllTimeHighscore()
    {
      try {
        File scoreTxt = new File("highscore.txt");
        if (scoreTxt.exists()) 
        {
          //File exists. 
          filePath = scoreTxt.toPath();
          String fileContents = new String(Files.readAllBytes(filePath));
          try
          {
            String[] splitContent = fileContents.split("-");
            allTimeHighsore = Integer.parseInt(splitContent[splitContent.length-1].trim());
          }
          catch(Exception e)
          {
            //File exists, but no content to split on.
            allTimeHighsore = 0;
          }
        } 
        else 
        {
          //File does not exist.
          scoreTxt.createNewFile();
          filePath = scoreTxt.toPath();
          FileWriter writer = new FileWriter(scoreTxt.getName());
          writer.write("");
          filePath = scoreTxt.toPath();
          allTimeHighsore = 0;
        }
      } catch (IOException e) 
      {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }

    static void newHighScoreReached()
    {
      //Format for txt file:
      //Name - Score
      //Ex:
      //Bike - 4
      System.out.println("Congrats, you have reached a new high score! Please enter your name below to register your new score!");
      String name = scanner.nextLine();
      String leaderboard = name + " - " + currentScore;
      try 
      {
        Files.write(filePath, leaderboard.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
      } 
      catch (IOException e) 
      {
        e.printStackTrace();
      }
      Events.log("🎉🎉New high score reached: "+leaderboard);
    }

    public static boolean isCurrentScoreNewHighScore()
    {
        boolean isNewHighScore;
        if(currentScore>allTimeHighsore)
            isNewHighScore=true;
        else
            isNewHighScore=false;
        return isNewHighScore;
    }
}
