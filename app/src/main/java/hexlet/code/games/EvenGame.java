package hexlet.code.games;


import java.util.Random;

import hexlet.code.GameRunner;

import static hexlet.code.Utils.generateRandomInt;


public class EvenGame {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void startEvenGame() {
        String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] questionsAndAnswers = generateEvenQuestions();
        GameRunner.playGame(rules, questionsAndAnswers);
    }

    private static String[][] generateEvenQuestions() {
        Random rand = new Random();
        String[][] questionsAndAnswers = new String[GameRunner.NUMBER_OF_QUESTIONS][2];

        for (int i = 0; i < GameRunner.NUMBER_OF_QUESTIONS; i++) {
            int number = generateRandomInt(MIN_NUMBER, MAX_NUMBER);
            String question = String.valueOf(number);
            String answer = number % 2 == 0 ? "yes" : "no";
            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
        }

        return questionsAndAnswers;
    }
}
