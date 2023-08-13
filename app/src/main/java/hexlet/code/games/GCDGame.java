package hexlet.code.games;


import java.util.Random;
import java.util.Scanner;

import hexlet.code.GameRunner;
import hexlet.code.Utils.QuestionAnswer;

public class GCDGame {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void startGCDGame(Scanner scanner) {
        String rules = "Find the greatest common divisor of given numbers.";
        QuestionAnswer[] questionsAndAnswers = generateGCDQuestions();
        GameRunner.playGame(scanner, rules, questionsAndAnswers);
    }

    private static QuestionAnswer[] generateGCDQuestions() {
        Random rand = new Random();
        QuestionAnswer[] questionsAndAnswers = new QuestionAnswer[GameRunner.NUMBER_OF_QUESTIONS];

        for (int i = 0; i < GameRunner.NUMBER_OF_QUESTIONS; i++) {
            int number1 = rand.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            int number2 = rand.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            String question = number1 + " " + number2;
            String answer = String.valueOf(gcd(number1, number2));
            questionsAndAnswers[i] = new QuestionAnswer(question, answer);
        }

        return questionsAndAnswers;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
