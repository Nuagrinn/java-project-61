package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.GameRunner.getPlayerName;
import static hexlet.code.GameRunner.runPrimeGame;
import static hexlet.code.GameRunner.congratulatePlayer;
public class PrimeGame {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        String name = getPlayerName(scanner);

        runPrimeGame(name, scanner);

    }
}
