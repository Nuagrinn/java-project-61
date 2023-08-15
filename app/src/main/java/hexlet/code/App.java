package hexlet.code;

import hexlet.code.games.PrimeGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.ProgressionGame;


import java.util.Scanner;


public class App {

    public static final int GAME_GREET = 1;
    public static final int GAME_EVEN = 2;
    public static final int GAME_CALC = 3;
    public static final int GAME_GCD = 4;
    public static final int GAME_PROGRESSION = 5;
    public static final int GAME_PRIME = 6;
    public static final int EXIT = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(GAME_GREET + " - Greet");
        System.out.println(GAME_EVEN + " - Even");
        System.out.println(GAME_CALC + " - Calc");
        System.out.println(GAME_GCD + " - GCD");
        System.out.println(GAME_PROGRESSION + " - Progression");
        System.out.println(GAME_PRIME + " - Prime");
        System.out.println(EXIT + " - Exit");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case GAME_GREET:
                Cli.run();
                break;
            case GAME_EVEN:
                EvenGame.startEvenGame();
                break;
            case GAME_CALC:
                CalcGame.startCalcGame();
                break;
            case GAME_GCD:
                GCDGame.startGCDGame();
                break;
            case GAME_PROGRESSION:
                ProgressionGame.startProgressionGame();
                break;
            case GAME_PRIME:
                PrimeGame.startPrimeGame();
                break;
            case EXIT:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Goodbye!");
        }
        scanner.close();
    }

}
