package com.janken;

import java.util.Optional;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

public class App 
{
    //The variables within this scope will allow them to be used 
    //within the entire class, and other classes if necessary.
    public static boolean quitGame = false;
    public static boolean vsCPU = false;
    
    public static Scanner scanner = new Scanner(System.in);

    public static int score;
    public static int roundCount = 0;
    public static int previousWinner; //Used to determine a streak. Value corresponds to player #. Tie does not affect.
    
    public static void main( String[] args )
    {
        //We now start by presenting the user a login page. 
        Session.login();
    }

    static void startNewGame()
    {
        
        System.out.print("Welcome to Janken! Single player mode? Y/N:");
        String mode = scanner.nextLine().toLowerCase();
   
       //reset counts
       roundCount = 0;
        previousWinner = 0;    
    
        boolean modeSet = false;
        while(!modeSet)
            {
                //This loop will run until modeSet is true. 
                if(mode.equals("y")||mode.equals("yes"))
                {
                    vsCPU = true;
                    modeSet = true;
                }
                else if(mode.equals("n") || mode.equals("no"))
                {
                    vsCPU = false;
                    modeSet = true;
                }
                else
                    System.out.println("Sorry, please try again. ");
            }
    
            if(vsCPU)
                SinglePlayer.begin();
            else
                TwoPlayer.begin();
        }   
    static void gameOver()
    {
        //Method may not be necessary.
    }

    static void displayRules()
    {
       if(vsCPU)
       {
        System.out.println("\n\nIn single player mode, you will go first, then I will randomly pick my choice.");
       }
       else
       {
        System.out.println("In two player mode, player 1 will make their choice first by typing in their respective option."
        +"\nThen, player 2 will make their choice, and the winner will be displayed.");
       }
       System.out.println("There are two ways to input your options; either their name, or the corresponding number. The"
       +" options and their strengths/weaknesses are as follows: Rock (1) beats scissors, but loses to paper.\nPaper (2) beats rock, but"
       + " loses to scissors.\nScissors (3) beats paper, but loses to rock. Good luck!");
    }

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

    /**
     * Method to decide who is the winner of the round.
     * @param p1Move Player 1's move. Not necessary to pass lowercase.
     * @param p2Move Player 2's move. Not necessary to pass lowercase.
     * @return int value of 0 = tie, 1 = p1/player win, 2 = p2/cpu win
     */
    static int decisionTree(String p1Move,String p2Move)
    {
        int decision;
        /*
         * Rock 1
         * Paper 2
         * Scissors 3
         */
        switch(p1Move.toLowerCase())
        {
            case "rock":
            case "1":

            if(p2Move.equals("paper")||p2Move.equals("2"))
                decision = 2;
            else if(p2Move.equals("scissors")||p2Move.equals("3"))
                decision = 1;
            else
                decision = 0;
            break;

            case "paper":
            case "2":

            if(p2Move.equals("rock")||p2Move.equals("1"))
                decision = 1;
            else if(p2Move.equals("scissors")||p2Move.equals("3"))
                decision = 2;
            else
                decision = 0;
            break;

            case "scissors":
            case "scissor": //typo catch :)
            case "3":

            if(p2Move.equals("paper")||p2Move.equals("2"))
                decision = 1;
            else if(p2Move.equals("rock")||p2Move.equals("1"))
                decision = 2;
            else
                decision = 0;
        }
        
        if(decision!=0)
            previousWinner=decision;

        roundCount++;
        return decision;

        
    }

    


}
