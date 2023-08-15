package hexlet.code.games;

import java.util.Random;
import hexlet.code.GameRunner;

import static hexlet.code.Utils.generateRandomInt;

public class PrimeGame {

    private static final int MIN_NUMBER = 2;
    private static final int MAX_NUMBER = 100;

    public static void startPrimeGame() {
        String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[][] questionsAndAnswers = generatePrimeQuestions();
        GameRunner.playGame(rules, questionsAndAnswers);
    }

    private static String[][] generatePrimeQuestions() {
        Random rand = new Random();
        String[][] questionsAndAnswers = new String[GameRunner.NUMBER_OF_QUESTIONS][2];

        for (int i = 0; i < GameRunner.NUMBER_OF_QUESTIONS; i++) {
            int number = generateRandomInt(MIN_NUMBER, MAX_NUMBER);
            String question = String.valueOf(number);
            String answer = isPrime(number) ? "yes" : "no";
            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
        }

        return questionsAndAnswers;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
