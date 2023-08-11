package hexlet.code.games;


import java.util.Random;
import java.util.Scanner;

import hexlet.code.GameRunner;
import hexlet.code.Utils.QuestionAnswer;


public class ProgressionGame {

    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int MIN_DIFFERENCE = 1;
    private static final int MAX_DIFFERENCE = 10;
    private static final int MIN_START = 1;
    private static final int MAX_START = 100;

    public static void startProgressionGame(Scanner scanner) {
        System.out.print("May I have your name? ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        String rules = "What number is missing in the progression?";
        QuestionAnswer[] questionsAndAnswers = generateProgressionQuestions();
        GameRunner.playGame(scanner, name, rules, questionsAndAnswers);
    }

    private static QuestionAnswer[] generateProgressionQuestions() {
        Random rand = new Random();
        QuestionAnswer[] questionsAndAnswers = new QuestionAnswer[GameRunner.NUMBER_OF_QUESTIONS];

        for (int i = 0; i < GameRunner.NUMBER_OF_QUESTIONS; i++) {
            int length = rand.nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;
            int difference = rand.nextInt(MAX_DIFFERENCE - MIN_DIFFERENCE + 1) + MIN_DIFFERENCE;
            int start = rand.nextInt(MAX_START - MIN_START + 1) + MIN_START;
            int hiddenIndex = rand.nextInt(length);
            StringBuilder question = new StringBuilder();
            String answer = "";

            for (int j = 0; j < length; j++) {
                if (j == hiddenIndex) {
                    question.append(".. ");
                    answer = String.valueOf(start + j * difference);
                } else {
                    question.append(start + j * difference).append(" ");
                }
            }

            questionsAndAnswers[i] = new QuestionAnswer(question.toString().trim(), answer);
        }

        return questionsAndAnswers;
    }
}
