package com.janken;

import java.util.Scanner;
import java.lang.Math;



public class App 
{
    public static boolean quitGame = false;
    public static boolean vsCPU = false;
    
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main( String[] args )
    {
        while (!quitGame)
        {
            run();
        }
    }

    static void run()
    {
        //Logic to execute the first steps of initializing game.
        //Get input from user to determine game mode. 
        System.out.print("Welcome to <game>! Single player mode? Y/N:");
        String mode = scanner.nextLine().toLowerCase();

        if(mode.equals("y")||mode.equals("yes"))
            vsCPU = true;
        else if(mode.equals("n") || mode.equals("no"))
            vsCPU = false;
        else
            //missing logic to retry input. Either mode set as method & return bool, or while loop.
            System.out.println("Sorry, please try again. ");

    }

    static void displayRules()
    {
        //If user requests at any point to display the rules, this method gets called.
    }

    static void gameOver()
    {
        //Method may not be necessary.
    }

    static void displayHighScore()
    {
        //Shows the highest score.
    }


}
