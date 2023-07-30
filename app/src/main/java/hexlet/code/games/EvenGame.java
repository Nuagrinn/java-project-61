package hexlet.code.games;

import java.util.Scanner;

import static hexlet.code.GameRunner.getPlayerName;
import static hexlet.code.GameRunner.runEvenGame;
import static hexlet.code.GameRunner.congratulatePlayer;



public class EvenGame {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        String name = getPlayerName(scanner);

        runEvenGame(name, scanner);
        congratulatePlayer(name);

    }

}
