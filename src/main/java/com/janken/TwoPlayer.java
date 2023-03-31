package com.janken;

import java.util.Scanner;

public class TwoPlayer {
    
    static Scanner scanner = new Scanner(System.in);

    public static void begin()
    {
        App.displayRules();

        //Player 1 moves
        String p1Move;

        System.out.print("Player 1, make yor choice: ");
        p1Move = scanner.nextLine();

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");//This is to prevent player 2 from instantly seeing player 1's move.

        //Player 2 moves
        String p2Move;

        System.out.print("Player 2, it's your turn. Make your move: ");
        p2Move = scanner.nextLine();

        int winner = App.decisionTree(p1Move, p2Move);
        if(App.vsCPU==true)
        {
            if(winner==1)
                System.out.println("Player 1 has won round "+App.roundCount+"!");
        }

    }
}

