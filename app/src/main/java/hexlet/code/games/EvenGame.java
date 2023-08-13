package hexlet.code.games;


import java.util.Random;
import java.util.Scanner;

import hexlet.code.GameRunner;
import hexlet.code.Utils.QuestionAnswer;

public class EvenGame {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void startEvenGame(Scanner scanner) {
        String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        QuestionAnswer[] questionsAndAnswers = generateEvenQuestions();
        GameRunner.playGame(scanner, rules, questionsAndAnswers);
    }

    private static QuestionAnswer[] generateEvenQuestions() {
        Random rand = new Random();
        QuestionAnswer[] questionsAndAnswers = new QuestionAnswer[GameRunner.NUMBER_OF_QUESTIONS];

        for (int i = 0; i < GameRunner.NUMBER_OF_QUESTIONS; i++) {
            int number = rand.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            String question = String.valueOf(number);
            String answer = number % 2 == 0 ? "yes" : "no";
            questionsAndAnswers[i] = new QuestionAnswer(question, answer);
        }

        return questionsAndAnswers;
    }
}

