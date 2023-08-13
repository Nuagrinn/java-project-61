package hexlet.code.games;


import java.util.Random;
import java.util.Scanner;

import hexlet.code.GameRunner;
import hexlet.code.Utils.QuestionAnswer;

public class PrimeGame {

    private static final int MIN_NUMBER = 2;
    private static final int MAX_NUMBER = 100;

    public static void startPrimeGame(Scanner scanner) {
        String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        QuestionAnswer[] questionsAndAnswers = generatePrimeQuestions();
        GameRunner.playGame(scanner, rules, questionsAndAnswers);
    }

    private static QuestionAnswer[] generatePrimeQuestions() {
        Random rand = new Random();
        QuestionAnswer[] questionsAndAnswers = new QuestionAnswer[GameRunner.NUMBER_OF_QUESTIONS];

        for (int i = 0; i < GameRunner.NUMBER_OF_QUESTIONS; i++) {
            int number = rand.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            String question = String.valueOf(number);
            String answer = isPrime(number) ? "yes" : "no";
            questionsAndAnswers[i] = new QuestionAnswer(question, answer);
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
