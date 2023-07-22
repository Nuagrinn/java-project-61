package hexlet.code.games;

import java.util.Scanner;

public class GCDGame {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 100;
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println("Find the greatest common divisor of given numbers.");

        int correctAnswers = 0;
        final int roundsToWin = 3;

        while (correctAnswers < roundsToWin) {
            int num1 = generateRandomNumber();
            int num2 = generateRandomNumber();
            int gcd = calculateGCD(num1, num2);

            System.out.println("Question: " + num1 + " " + num2);
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == gcd) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + gcd + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + name + "!");
    }

    private static int generateRandomNumber() {
        return 1 + (int) (Math.random() * (MAX_NUM - MIN_NUM + 1));
    }

    private static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}
