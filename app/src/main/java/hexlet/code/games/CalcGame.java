package hexlet.code.games;


import java.util.Random;

import hexlet.code.GameRunner;

import static hexlet.code.Utils.generateRandomInt;


public class CalcGame {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final String[] OPERATORS = {"+", "-", "*"};

    public static void startCalcGame() {
        String rules = "What is the result of the expression?";
        String[][] questionsAndAnswers = generateCalcQuestions();
        GameRunner.playGame(rules, questionsAndAnswers);
    }

    private static String[][] generateCalcQuestions() {
        Random rand = new Random();
        String[][] questionsAndAnswers = new String[GameRunner.NUMBER_OF_QUESTIONS][2];

        for (int i = 0; i < GameRunner.NUMBER_OF_QUESTIONS; i++) {
            int num1 = generateRandomInt(MIN_NUMBER, MAX_NUMBER);
            int num2 = generateRandomInt(MIN_NUMBER, MAX_NUMBER);
            String operator = OPERATORS[rand.nextInt(OPERATORS.length)];
            String question = num1 + " " + operator + " " + num2;
            int answer = calculate(num1, num2, operator);
            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = String.valueOf(answer);
        }
        return questionsAndAnswers;
    }

    private static int calculate(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
