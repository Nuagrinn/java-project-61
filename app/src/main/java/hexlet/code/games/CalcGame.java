package hexlet.code.games;


import java.util.Random;
import java.util.Scanner;
import hexlet.code.Utils.QuestionAnswer;
import hexlet.code.GameRunner;

public class CalcGame {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final String[] OPERATORS = {"+", "-", "*"};

    public static void startCalcGame(Scanner scanner) {
        System.out.print("May I have your name? ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        String rules = "What is the result of the expression?";
        QuestionAnswer[] questionsAndAnswers = generateCalcQuestions();
        GameRunner.playGame(scanner, name, rules, questionsAndAnswers);
    }

    private static QuestionAnswer[] generateCalcQuestions() {
        Random rand = new Random();
        QuestionAnswer[] questionsAndAnswers = new QuestionAnswer[GameRunner.NUMBER_OF_QUESTIONS];

        for (int i = 0; i < GameRunner.NUMBER_OF_QUESTIONS; i++) {
            int num1 = rand.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            int num2 = rand.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            String operator = OPERATORS[rand.nextInt(OPERATORS.length)];
            String question = num1 + " " + operator + " " + num2;
            int answer = calculate(num1, num2, operator);
            questionsAndAnswers[i] = new QuestionAnswer(question, String.valueOf(answer));
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
