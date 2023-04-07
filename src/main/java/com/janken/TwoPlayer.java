package com.janken;

import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public static class TwoPlayer {
    
    static Scanner scanner = new Scanner(System.in);

    public static void begin()
    {
        App.displayRules();

        //Player 1 moves
        String p1Move;

        System.out.print("Player 1, make your choice: ");
        p1Move = scanner.nextLine();

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");//This is to prevent player 2 from instantly seeing player 1's move.

        //Player 2 moves
        String p2Move;

        System.out.print("Player 2, it's your turn. Make your move: ");
        p2Move = scanner.nextLine();

        int winner = App.decisionTree(p1Move, p2Move);
    
        if(winner==1)//ternary check is not needed. this is *in* TwoPlayer.java 
            System.out.println((App.vsCPU ? "You":"Player 1")+" won round "+App.roundCount+"!");
        else if(winner=2)
            System.out.println((App.vsCPU ? "The Computer":"Player 2")+"  won round "+App.roundCount+"!");
        else
            System.out.println("Tie! You both picked "+p1Move.toLowerCase()+"!");

    }
}

