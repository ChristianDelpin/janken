package com.janken;

import java.util.Random;
import java.util.Scanner;

public class SinglePlayer {
    
    public static void begin()
    {
        App.roundCount=1;
        App.displayRules();

        Scanner scanner = new Scanner(System.in);

        String playerMove="";
        String cpuMove;

        boolean quitGame = false;
        while(!quitGame)
        {
            System.out.println("\tROUND "+App.roundCount);
            boolean successfulPlayerMove = false;

            while(!successfulPlayerMove)
            {
                System.out.print("Make your choice: ");
                playerMove=scanner.nextLine();
                playerMove=playerMove.toLowerCase();
                
                if(playerMove.equals("score"))
                {
                    Score.displayHighScore();
                    Events.log("Displayed score.");
                }
                else if(playerMove.equals("quit"))
                {
                    Events.log("Player has ended game.");
                    if(Score.isCurrentScoreNewHighScore() && App.previousWinner==1)
                    {
                        System.out.println("OK, game will close, but just before you go...");
                        Score.newHighScoreReached();
                    }
                    System.out.println("Thanks for playing Janken!");
                    quitGame=true;
                    return;
                }
                else if(!Events.isAMove(playerMove))
                {
                    System.out.println("Sorry, that is not a valid move. Please try again.");
                    Events.log("Player chose an invalid move: "+playerMove);
                }
                else
                    successfulPlayerMove=true;
            }
            Events.log("Player chose "+playerMove);
            System.out.println("CPU is choosing their move...");
            cpuMove = randomMove();
            Events.log("CPU move selected: "+cpuMove);
            int roundWinner = App.decisionTree(playerMove, cpuMove);

            if(roundWinner==1)
                System.out.println("You have won round "+App.roundCount+"!\n");
            else if(roundWinner==2)
                System.out.println("CPU won round "+App.roundCount+"!\n");
            else
                System.out.println("Tie! You both picked "+playerMove.toLowerCase()+"!\n");

            Events.log("Round "+App.roundCount+" winner: "+roundWinner);
            App.roundCount++;

            if(App.previousWinner!=roundWinner)
            {
                /*
                 * If there is a high score, and the high score is set by the player (NOT the cpu)
                 * Since the streak was lost, we use the previous winner value.
                 */
                if(Score.isCurrentScoreNewHighScore() && App.previousWinner == 1)
                {
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

    private static String randomMove()
    {
        String move = null;
        Random randomNum = new Random();
        int roll = randomNum.nextInt(3);
        switch(roll)
        {
            case 0:
                move="rock";
                break;
            case 1:
                move="paper";
                break;
            case 2:
                move="scissors";
                break;
            default://Sets default move to paper if !(0 ≤ roll ≤ 2)
                move="paper";
                break;
        }

        Events.log("CPU chose "+move+'.');
        return move;
    }
}
