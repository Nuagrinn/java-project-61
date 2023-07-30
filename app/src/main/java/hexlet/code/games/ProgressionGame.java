package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.GameRunner.getPlayerName;
import static hexlet.code.GameRunner.runProgressionGame;
import static hexlet.code.GameRunner.congratulatePlayer;

public class ProgressionGame {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        String name = getPlayerName(scanner);

        runProgressionGame(name, scanner);

    }

}
