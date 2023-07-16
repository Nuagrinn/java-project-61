package hexlet.code;

import java.util.Random;

public class GCDGame extends Game {
    private Random random;

    public GCDGame() {
        random = new Random();
    }

    @Override
    protected void showInstructions() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    @Override
    protected int getWinningCondition() {
        return 3;
    }

    @Override
    protected String generateQuestion() {
        int number1 = random.nextInt(100) + 1;
        int number2 = random.nextInt(100) + 1;
        return number1 + " " + number2;
    }

    @Override
    protected boolean checkAnswer(String question, String userAnswer) {
        int number1 = Integer.parseInt(question.split(" ")[0]);
        int number2 = Integer.parseInt(question.split(" ")[1]);
        int expectedAnswer = findGCD(number1, number2);

        return Integer.parseInt(userAnswer) == expectedAnswer;
    }

    @Override
    protected void handleWrongAnswer(String question, String userAnswer) {
        int number1 = Integer.parseInt(question.split(" ")[0]);
        int number2 = Integer.parseInt(question.split(" ")[1]);
        int expectedAnswer = findGCD(number1, number2);

        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + expectedAnswer + "'.");
        System.out.println("Let's try again, " + playerName + "!");
    }

    @Override
    protected void showCongratulations() {
        System.out.println("Congratulations, " + playerName + "!");
    }

    private int findGCD(int number1, int number2) {
        while (number2 != 0) {
            int temp = number2;
            number2 = number1 % number2;
            number1 = temp;
        }
        return number1;
    }
}

