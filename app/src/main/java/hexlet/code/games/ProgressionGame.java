package hexlet.code.games;

import java.util.Scanner;

public class ProgressionGame {
    private static final int MIN_START_NUM = 1;
    private static final int MAX_START_NUM = 20;
    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 10;
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MISSING_NUMBER_PLACEHOLDER = -1;

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println("What number is missing in the progression?");

        int correctAnswers = 0;
        final int roundsToWin = 3;

        while (correctAnswers < roundsToWin) {
            int startNum = generateRandomNumber(MIN_START_NUM, MAX_START_NUM);
            int step = generateRandomNumber(MIN_STEP, MAX_STEP);
            int length = generateRandomNumber(MIN_PROGRESSION_LENGTH, MAX_PROGRESSION_LENGTH);
            int missingIndex = generateRandomNumber(0, length - 1);
            int[] progression = generateArithmeticProgression(startNum, step, length);

            int missingNumber = progression[missingIndex];
            progression[missingIndex] = MISSING_NUMBER_PLACEHOLDER;

            System.out.print("Question: ");
            for (int num : progression) {
                if (num == MISSING_NUMBER_PLACEHOLDER) {
                    System.out.print(".. ");
                } else {
                    System.out.print(num + " ");
                }
            }
            System.out.println();

            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == missingNumber) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + missingNumber + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + name + "!");
    }

    private static int generateRandomNumber(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    private static int[] generateArithmeticProgression(int start, int step, int length) {
        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = start + step * i;
        }
        return progression;
    }
}
