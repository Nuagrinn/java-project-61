package hexlet.code;

import hexlet.code.games.PrimeGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.ProgressionGame;


import java.util.Scanner;


public class App {

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
            case 1:
                Cli.run();
                break;
            case 2:
                EvenGame.startEvenGame(scanner);
                break;
            case 3:
                CalcGame.startCalcGame(scanner);
                break;
            case 4:
                GCDGame.startGCDGame(scanner);
                break;
            case 5:
                ProgressionGame.startProgressionGame(scanner);
                break;
            case 6:
                PrimeGame.startPrimeGame(scanner);
            case 0:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Goodbye!");
        }
    }

}
