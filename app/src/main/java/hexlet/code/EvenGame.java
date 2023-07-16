package hexlet.code;

import java.util.Random;

public class EvenGame extends Game {
    private static final int MAX_NUMBER = 100;

    private Random random;

    public EvenGame() {
        random = new Random();
    }

    @Override
    protected void showInstructions() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    @Override
    protected int getWinningCondition() {
        return 3;
    }

    @Override
    protected String generateQuestion() {
        int number = random.nextInt(MAX_NUMBER);
        return String.valueOf(number);
    }

    @Override
    protected boolean checkAnswer(String question, String userAnswer) {
        int number = Integer.parseInt(question);
        boolean isEven = isEven(number);
        return (isEven && userAnswer.equals("yes")) || (!isEven && userAnswer.equals("no"));
    }

    @Override
    protected void handleWrongAnswer(String question, String userAnswer) {
        int number = Integer.parseInt(question);
        boolean isEven = isEven(number);
        String correctAnswer = isEven ? "no" : "yes";
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + playerName + "!");
    }

    @Override
    protected void showCongratulations() {
        System.out.println("Congratulations, " + playerName + "!");
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }
}
