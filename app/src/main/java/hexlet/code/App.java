package hexlet.code;

import java.util.Random;
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
        int gameNumber = Integer.parseInt(scanner.nextLine());

        if (gameNumber == 1) {
            Cli.run();
        } else if (gameNumber == 2) {
            Game evenGame = new EvenGame();
            evenGame.play();
        } else if (gameNumber == 3) {
            Game calcGame = new CalcGame();
            calcGame.play();
        } else if (gameNumber == 4) {
            Game gcdGame = new GCDGame();
            gcdGame.play();
        } else if (gameNumber == 5) {
            Game progressionGame = new ProgressionGame();
            progressionGame.play();
        } else if (gameNumber == 6) {
            Game primeGame = new PrimeGame();
            primeGame.play();
        } else if (gameNumber == 0) {
            System.out.println("Exiting the program. Goodbye!");
        } else {
            System.out.println("Invalid game number. Exiting the program. Goodbye!");
        }

        scanner.close();
    }
}
