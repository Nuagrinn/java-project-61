package hexlet.code.games;

import hexlet.code.GameRunner;

import static hexlet.code.Utils.generateRandomInt;

public class ProgressionGame {

    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int MIN_DIFFERENCE = 1;
    private static final int MAX_DIFFERENCE = 10;
    private static final int MIN_START = 1;
    private static final int MAX_START = 100;

    public static void startProgressionGame() {
        String rules = "What number is missing in the progression?";
        String[][] questionsAndAnswers = generateProgressionQuestions();
        GameRunner.playGame(rules, questionsAndAnswers);
    }

    private static String[][] generateProgressionQuestions() {
        String[][] questionsAndAnswers = new String[GameRunner.NUMBER_OF_QUESTIONS][2];

        for (int i = 0; i < GameRunner.NUMBER_OF_QUESTIONS; i++) {
            int length = generateRandomInt(MIN_LENGTH, MAX_LENGTH);
            int difference =  generateRandomInt(MIN_DIFFERENCE, MAX_DIFFERENCE);
            int start = generateRandomInt(MIN_START, MAX_START);
            int hiddenIndex = generateRandomInt(length);
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

            questionsAndAnswers[i][0] = question.toString().trim();
            questionsAndAnswers[i][1] = answer;
        }

        return questionsAndAnswers;
    }
}
