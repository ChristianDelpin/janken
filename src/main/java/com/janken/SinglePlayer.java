package com.janken;

import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

public static class SinglePlayer {
    
    public static void begin()
    {
        App.displayRules();
    }

    String randomMove()
    {
        String move;
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
        }

        return move;
    }
}
