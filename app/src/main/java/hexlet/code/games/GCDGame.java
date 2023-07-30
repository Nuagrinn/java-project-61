package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.GameRunner.getPlayerName;
import static hexlet.code.GameRunner.runGCDGame;
import static hexlet.code.GameRunner.congratulatePlayer;


public class GCDGame {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        String name = getPlayerName(scanner);

        runGCDGame(name, scanner);

    }

}
