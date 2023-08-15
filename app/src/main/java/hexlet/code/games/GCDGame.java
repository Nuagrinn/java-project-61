package hexlet.code.games;

import hexlet.code.GameRunner;

import static hexlet.code.Utils.generateRandomInt;

public class GCDGame {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void startGCDGame() {
        String rules = "Find the greatest common divisor of given numbers.";
        String[][] questionsAndAnswers = generateGCDQuestions();
        GameRunner.playGame(rules, questionsAndAnswers);
    }

    private static String[][] generateGCDQuestions() {
        String[][] questionsAndAnswers = new String[GameRunner.NUMBER_OF_QUESTIONS][2];

        for (int i = 0; i < GameRunner.NUMBER_OF_QUESTIONS; i++) {
            int number1 = generateRandomInt(MIN_NUMBER, MAX_NUMBER);
            int number2 = generateRandomInt(MIN_NUMBER, MAX_NUMBER);
            String question = number1 + " " + number2;
            String answer = String.valueOf(gcd(number1, number2));
            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
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
