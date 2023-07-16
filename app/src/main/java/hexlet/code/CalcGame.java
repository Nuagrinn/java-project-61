package hexlet.code;

import java.util.Random;

public class CalcGame extends Game {
    private static final int MAX_NUMBER = 100;
    private static final String[] OPERATORS = {"+", "-", "*"};

    private Random random;

    public CalcGame() {
        random = new Random();
    }

    @Override
    protected void showInstructions() {
        System.out.println("What is the result of the expression?");
    }

    @Override
    protected int getWinningCondition() {
        return 3;
    }

    @Override
    protected String generateQuestion() {
        int number1 = random.nextInt(MAX_NUMBER);
        int number2 = random.nextInt(MAX_NUMBER);
        String operator = OPERATORS[random.nextInt(OPERATORS.length)];

        return number1 + " " + operator + " " + number2;
    }

    @Override
    protected boolean checkAnswer(String question, String userAnswer) {
        int expectedAnswer = evaluateExpression(question);
        int userAnswerInt = Integer.parseInt(userAnswer);

        return userAnswerInt == expectedAnswer;
    }

    @Override
    protected void handleWrongAnswer(String question, String userAnswer) {
        int expectedAnswer = evaluateExpression(question);
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + expectedAnswer + "'.");
        System.out.println("Let's try again, " + playerName + "!");
    }

    @Override
    protected void showCongratulations() {
        System.out.println("Congratulations, " + playerName + "!");
    }

    private int evaluateExpression(String expression) {
        String[] parts = expression.split(" ");
        int number1 = Integer.parseInt(parts[0]);
        int number2 = Integer.parseInt(parts[2]);
        String operator = parts[1];

        int result = 0;
        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            default:
                break;
        }

        return result;
    }
}
