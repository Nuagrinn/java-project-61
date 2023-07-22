package hexlet.code.games;

import java.util.Scanner;

public class EvenGame {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 100;
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int correctAnswers = 0;
        final int roundsToWin = 3;

        while (correctAnswers < roundsToWin) {
            int number = generateRandomNumber(MIN_NUM, MAX_NUM);
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (isEven(number) && userAnswer.equals("yes") || !isEven(number) && userAnswer.equals("no")) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + (isEven(number) ? "yes" : "no") + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + name + "!");
    }

    private static int generateRandomNumber(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
