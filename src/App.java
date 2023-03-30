
import java.util.Scanner;
import java.util.Random;

public class App {
    public static boolean quitGame = false;
    public static boolean vsCPU = false;

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        while (!quitGame) {
            startNewGame();
        }
    }

    static void startNewGame() {
        System.out.print("Welcome to Janken! Single player mode? Y/N:");
        String mode = scanner.nextLine().toLowerCase();

        boolean modeSet = false;
        do {
            if (mode.equals("y") || mode.equals("yes")) {
                vsCPU = true;
                modeSet = true;
            } else if (mode.equals("n") || mode.equals("no")) {
                vsCPU = false;
                modeSet = true;
            } else
                System.out.println("Sorry, please try again. ");
        } while (!modeSet);

        if (vsCPU) {
            singlePlayer();
        } else {
            twoPlayer();
        }
    }

    static void singlePlayer() {
        System.out.println("Welcome to single player Janken. Below are the rules for this game:");
        displayRules();
        playGame();
    }

    static void twoPlayer() {
        System.out.println("Welcome to two-player Janken. Below are the rules for this game:");
        displayRules();
        playGame();
    }

    static void playGame() {
        System.out.println("Enter your move (rock, paper, scissors) or type 'quit' to exit the game:");
        String player1Move = scanner.nextLine().toLowerCase();

        if (player1Move.equals("quit")) {
            quitGame = true;
            return;
        }

        String player2Move;
        if (vsCPU) {
            player2Move = getRandomMove();
            System.out.println("CPU move: " + player2Move);
        } else {
            System.out.println("Player 2, enter your move (rock, paper, scissors):");
            player2Move = scanner.nextLine().toLowerCase();
        }

        String result = getWinner(player1Move, player2Move);
        System.out.println(result);
    }

    static String getRandomMove() {
        int randomMove = random.nextInt(3);
        switch (randomMove) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
        }
        return "rock"; // Should never happen
    }

    static String getWinner(String player1Move, String player2Move) {
        if (player1Move.equals(player2Move)) {
            return "It's a tie!";
        }

        if ((player1Move.equals("rock") && player2Move.equals("scissors"))
                || (player1Move.equals("paper") && player2Move.equals("rock"))
                || (player1Move.equals("scissors") && player2Move.equals("paper"))) {
            return vsCPU ? "You win!" : "Player 1 wins!";
        } else {
            return vsCPU ? "CPU wins!" : "Player 2 wins!";
        }
    }

    static void displayRules() {
        System.out.println("Rock beats Scissors");
        System.out.println("Scissors beats Paper");
        System.out.println("Paper beats Rock");
    }
}
