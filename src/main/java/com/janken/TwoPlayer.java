package com.janken;

import java.util.EventObject;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class TwoPlayer {

    public static void begin()
    {
        App.roundCount=1;
        App.displayRules();
        
        Scanner scanner = new Scanner(System.in);

        String p1Move=null;
        String p2Move=null;

        boolean quitGame=false;
        while(!quitGame)
        {
            System.out.println("\tROUND "+App.roundCount);

            boolean successfulP1Move = false;
            while(!successfulP1Move)
            {
                System.out.print("Player 1, make your choice: ");
                p1Move = scanner.nextLine();
                p1Move = p1Move.toLowerCase();
                if(p1Move.equals("score"))
                {
                    Score.displayHighScore();
                    Events.log("Displayed score.");
                }
                else if(p1Move.equals("quit"))
                {
                    Events.log("Player 1 has ended game.");
                    if(Score.isCurrentScoreNewHighScore())
                    {
                        System.out.println("OK, game will close, but before you go...");
                        Score.newHighScoreReached();
                    }
                    System.out.println("Thanks for playing Janken!");
                    quitGame=true;
                    return;
                }
                else if(!Events.isAMove(p1Move))
                {
                    System.out.println("Sorry, that is not a valid move. Please try again.");
                    Events.log("Player 1 chose an invalid move: "+p1Move);
                }
                else
                    successfulP1Move = true;
            }
            Events.log("Player 1 chose "+p1Move);

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");//This is to prevent player 2 from instantly seeing player 1's move.    


            //Player 2's turn

            
            boolean successfulP2Move=false;
            while(!successfulP2Move)
            {
                System.out.print("Player 2, make your choice: ");
                p2Move = scanner.nextLine();
                p2Move = p2Move.toLowerCase();
                if(p2Move.equals("score"))
                {
                    Score.displayHighScore();
                    Events.log("Displayed score.");
                }
                else if(p2Move.equals("quit"))
                {
                    Events.log("Player 2 has ended game.");
                    if(Score.isCurrentScoreNewHighScore())
                    {
                        System.out.println("OK, game will close, but before you go...");
                        Score.newHighScoreReached();
                    }
                    System.out.println("Thanks for playing Janken!");
                    quitGame=true;
                    return;
                }
                else if(!Events.isAMove(p2Move))
                {
                    System.out.println("Sorry, that is not a valid move. Please try again.");
                    Events.log("Player 2 chose an invalid move: "+p2Move);
                }
                else
                    successfulP2Move = true;
            }
            Events.log("Player 2 chose "+p2Move);

            int roundWinner = App.decisionTree(p1Move, p2Move);
    
            if(roundWinner==1)
                System.out.println("Player 1 won round "+App.roundCount+"!");
            else if(roundWinner==2)
                System.out.println("Player 2 won round "+App.roundCount+"!");
            else
                System.out.println("Tie! You both picked "+p1Move+"!");

            Events.log("Round "+App.roundCount+" winner: "+roundWinner);
            App.roundCount++;


            if(App.previousWinner!=roundWinner)
            {
                if(Score.isCurrentScoreNewHighScore() && roundWinner!=0)
                {
                    System.out.println("🎉🎉🎉🎉🎉 Player "+App.previousWinner+", you have set a new high score! 🎉🎉🎉🎉🎉");
                    Score.newHighScoreReached();
                    Score.currentScore=1;
                }
                else if(roundWinner!=0)//if it's not a tie
                {
                    Score.currentScore=1;//setting equal to 1 because set to 0, then give point to round winner.
                    App.previousWinner=roundWinner;
                }

                if(App.roundCount==0 && roundWinner!=0)//checking 1st round clause.
                    Score.currentScore++;
            }
            else if(App.previousWinner==roundWinner)
            {
                Score.currentScore++;
            }
        }
    }
}

