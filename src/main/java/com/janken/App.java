package com.janken;

import java.util.Scanner;

import java.lang.Math;



public class App 
{
    //The variables within this scope will allow them to be used 
    //within the entire class, and other classes if necessary.
    public static boolean quitGame = false;
    public static boolean vsCPU = false;
    
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main( String[] args )
    {
        while (!quitGame)
        {
            startNewGame();
        }
    }

    static void startNewGame()
    {
        //Logic to execute the first steps of initializing game.
        //Get input from user to determine game mode. 
        System.out.print("Welcome to <game>! Single player mode? Y/N:");
        String mode = scanner.nextLine().toLowerCase();

        boolean modeSet = false;
        do
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
        while(!modeSet);

        if(vsCPU)
            singlePlayer();
        else
            twoPlayer();
    }

    static void singlePlayer()
    {
        System.out.println("Welcome to single player Janken. Below are the rules for this game:");
        displayRules();
    }

    static void twoPlayer()
    {
        System.out.println("Welcome to two-player Janken. Below are the rules for this game:");
        displayRules();
    }

    static void gameOver()
    {
        //Method may not be necessary.
    }

    static void displayRules()
    {
       if(vsCPU)
       {
        //display singlePlayer mode rules
       }
       else
       {
        //display twoPlayer mode rules
       }
    }

    static void displayHighScore()
    {
        //Shows the highest score.
    }


}
