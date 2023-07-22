package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.GCDGame;



import java.util.Scanner;

public class App {
    // Constants for game choices
    private static final int GREET_CHOICE = 1;
    private static final int EVEN_CHOICE = 2;
    private static final int CALC_CHOICE = 3;
    private static final int GCD_CHOICE = 4;
    private static final int PROGRESSION_CHOICE = 5;
    private static final int PRIME_CHOICE = 6;
    private static final int EXIT_CHOICE = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case GREET_CHOICE:
                Cli.run();
                break;
            case EVEN_CHOICE:
                EvenGame.run();
                break;
            case CALC_CHOICE:
                CalcGame.run();
                break;
            case GCD_CHOICE:
                GCDGame.run();
                break;
            case PROGRESSION_CHOICE:
                ProgressionGame.run();
                break;
            case PRIME_CHOICE:
                PrimeGame.run();
                break;
            case EXIT_CHOICE:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Goodbye!");
        }
    }
}




