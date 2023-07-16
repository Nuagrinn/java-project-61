package hexlet.code;

import java.util.Random;

public class PrimeGame extends Game {
    @Override
    protected void showInstructions() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    @Override
    protected int getWinningCondition() {
        return 3; // Number of correct answers required to win
    }

    @Override
    protected String generateQuestion() {
        int number = getRandomNumber();
        return String.valueOf(number);
    }

    @Override
    protected boolean checkAnswer(String question, String userAnswer) {
        int number = Integer.parseInt(question);
        boolean isPrime = isPrimeNumber(number);
        return (isPrime && userAnswer.equalsIgnoreCase("yes"))
                || (!isPrime && userAnswer.equalsIgnoreCase("no"));
    }

    @Override
    protected void handleWrongAnswer(String question, String userAnswer) {
        int number = Integer.parseInt(question);
        boolean isPrime = isPrimeNumber(number);
        String correctAnswer = isPrime ? "yes" : "no";

        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + playerName + "!");
    }

    @Override
    protected void showCongratulations() {
        System.out.println("Congratulations, " + playerName + "!");
    }

    private boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1; // Generate a random number between 1 and 100 (inclusive)
    }
}
