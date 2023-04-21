package com.janken;


import java.util.Scanner;


public class Session {

    //Final keyword prevents accidentally overwriting the value of the variable.
    final static String actualUsername = "team 6";
    final static String actualPassword = "123";


    static void login()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Username: ");
        String inputUsername = scanner.nextLine();

        System.out.println("Enter password: ");
        String inputPassword = scanner.nextLine();

        if(actualUsername.equals(inputUsername) && actualPassword.equals(inputPassword))
        {
            System.out.println("Login successful.");
            Events.log("User logged in successfully.");
            App.startNewGame();
        }
        else
        {
            System.out.println("Username or password is incorrect. Try again.");
            Events.log("User failed login authentication.");
            login();
        }
    }


}
