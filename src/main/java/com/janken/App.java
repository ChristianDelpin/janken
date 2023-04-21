package com.janken;

import java.util.Scanner;

public class App 
{
    //The variables within this scope will allow them to be used 
    //within the entire class, and other classes if necessary.
    public static boolean quitGame = false;
    public static boolean vsCPU = false;

    public static int roundCount = 1;
    public static int previousWinner; //Used to determine a streak. Value corresponds to player #. Tie does not affect.
    
    public static void main( String[] args )
    {
        //We now start by presenting the user a login page.
        Score.setAllTimeHighscore(); 
        Session.login();
    }

    /**
     * Performs all initial logic to start a new game.
     */
    static void startNewGame()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to Janken! Single player mode? Y/N:");
        String mode = scanner.nextLine().toLowerCase();
        

       //reset counts
       roundCount = 1;
       previousWinner = 0;    
    
        boolean modeSet = false;
        while(!modeSet)
            {
                //This loop will run until modeSet is true. 
                if(mode.equals("y")||mode.equals("yes"))
                {
                    vsCPU = true;
                    modeSet = true;
                    //Events.log("Mode set to Singleplayer.");
                }
                else if(mode.equals("n") || mode.equals("no"))
                {
                    vsCPU = false;
                    modeSet = true;
                    //Events.log("Mode set to Two Player.");
                }
                else
                {
                    System.out.println("Sorry, please try again. ");
                    System.out.print("Welcome to Janken! Single player mode? Y/N:");
                    mode = scanner.nextLine().toLowerCase();
                }
            }
    
            if(vsCPU)
                SinglePlayer.begin();
            else
                TwoPlayer.begin();
        }   

    /**
     * If a player decides to end the game, then <b>gameOver()</b> is called. <br>
     * Method checks if there is a new high score, and provides a brief game summary.
     */
    static void gameOver()
    {
        
    }

    /**
     * Checks game mode to determine if single player, or 2-player. Then, displays the rules accordingly. 
     */
    static void displayRules()
    {
       if(vsCPU)
       {
        System.out.println("\n\nIn single player mode, you will go first, then I will randomly pick my choice.");
       }
       else
       {
        System.out.println("In two player mode, player 1 will make their choice first by typing in their respective option."
        +"\nThen, player 2 will make their choice.");
       }
       System.out.println("There are two ways to input your options; either their name, or the corresponding number. The"
       +" options and their strengths/weaknesses are as follows:\nRock (1) beats scissors, but loses to paper.\nPaper (2) beats rock, but"
       +" loses to scissors.\nScissors (3) beats paper, but loses to rock. Good luck!");

       System.out.println();
       Events.log("Displayed rules.");
    }

    /**
     * Method to decide who is the winner of the round.
     * @param p1Move Player 1's move. Not necessary to pass lowercase.
     * @param p2OrCPUMove Player 2 or CPU's move. Not necessary to pass lowercase.
     * @return int value of 0 = tie, 1 = p1/player win, 2 = p2/cpu win. -1 = error
     * 
     */
    static int decisionTree(String p1Move,String p2OrCPUMove)
    {
        int decision=-1;
        /*
         * Rock 1
         * Paper 2
         * Scissors 3
         */
        switch(p1Move.toLowerCase())
        {

            /*
             * This switch case is the same as the one in the master branch, but expanded for
             * readability, as well as allowing multiple inputs for the user.
             */
            case "rock":
            case "1":

            if(p2OrCPUMove.equals("paper")||p2OrCPUMove.equals("2"))
                decision = 2;
            else if(p2OrCPUMove.equals("scissors")||p2OrCPUMove.equals("3"))
                decision = 1;
            else
                decision = 0;
            break;

            case "paper":
            case "2":

            if(p2OrCPUMove.equals("rock")||p2OrCPUMove.equals("1"))
                decision = 1;
            else if(p2OrCPUMove.equals("scissors")||p2OrCPUMove.equals("3"))
                decision = 2;
            else
                decision = 0;
            break;

            case "scissors":
            case "scissor": //typo catch :)
            case "3":

            if(p2OrCPUMove.equals("paper")||p2OrCPUMove.equals("2"))
                decision = 1;
            else if(p2OrCPUMove.equals("rock")||p2OrCPUMove.equals("1"))
                decision = 2;
            else
                decision = 0;
        }
        return decision;

        
    }

    


}
