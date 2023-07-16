package hexlet.code;

import java.util.Random;

public class ProgressionGame extends Game {
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MIN_DIFFERENCE = 1;
    private static final int MAX_DIFFERENCE = 10;

    private int missingIndex;
    private int missingNumber;
    private String progressionString;

    @Override
    protected void showInstructions() {
        System.out.println("What number is missing in the progression?");
    }

    @Override
    protected int getWinningCondition() {
        return 3; // Number of correct answers required to win
    }

    @Override
    protected String generateQuestion() {
        int progressionLength = getRandomNumberInRange(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
        int difference = getRandomNumberInRange(MIN_DIFFERENCE, MAX_DIFFERENCE);

        missingIndex = getRandomNumberInRange(0, progressionLength - 1);

        StringBuilder builder = new StringBuilder();
        int currentNumber = getRandomNumber();
        for (int i = 0; i < progressionLength; i++) {
            if (i == missingIndex) {
                missingNumber = currentNumber;
                builder.append(".. ");
            } else {
                builder.append(currentNumber).append(" ");
            }
            currentNumber += difference;
        }

        progressionString = builder.toString().trim();
        return progressionString;
    }

    @Override
    protected boolean checkAnswer(String question, String userAnswer) {
        int answer;
        try {
            answer = Integer.parseInt(userAnswer);
        } catch (NumberFormatException e) {
            return false;
        }

        return answer == missingNumber;
    }

    @Override
    protected void handleWrongAnswer(String question, String userAnswer) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + missingNumber + "'.");
        System.out.println("Let's try again, " + playerName + "!");
    }

    @Override
    protected void showCongratulations() {
        System.out.println("Congratulations, " + playerName + "!");
    }

    private int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(100); // You can adjust the range of random numbers as needed
    }
}
