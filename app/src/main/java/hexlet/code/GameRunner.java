package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Utils.calculateExpression;
import static hexlet.code.Utils.generateRandomNumber;
import static hexlet.code.Utils.isEven;
import static hexlet.code.Utils.generateArithmeticProgression;
import static hexlet.code.Utils.generateRandomOperator;
import static hexlet.code.Utils.calculateGCD;
import static hexlet.code.Utils.isPrimeNumber;






public class GameRunner {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 100;
    private static final int MIN_START_NUM = 1;
    private static final int MAX_START_NUM = 20;
    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 10;
    private static final int MIN_PROGRESSION_LENGTH = 5;
    private static final int MAX_PROGRESSION_LENGTH = 10;
    private static final int MISSING_NUMBER_PLACEHOLDER = -1;


    public static void runEvenGame(String name, Scanner scanner) {
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
                informUserAboutWrongAnswer(userAnswer, correctAnswers, name);
                return;
            }
        }
        congratulatePlayer(name);

    }

    public static void runCalcGame(String name, Scanner scanner) {
        System.out.println("What is the result of the expression?");

        int correctAnswers = 0;
        final int roundsToWin = 3;

        while (correctAnswers < roundsToWin) {
            int num1 = generateRandomNumber(MIN_NUM, MAX_NUM);
            int num2 = generateRandomNumber(MIN_NUM, MAX_NUM);
            char operator = generateRandomOperator();

            int result = calculateExpression(num1, num2, operator);

            System.out.println("Question: " + num1 + " " + operator + " " + num2);
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == result) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                informUserAboutWrongAnswer(userAnswer, correctAnswers, name);
                return;
            }
        }
        congratulatePlayer(name);

    }

    public static void runGCDGame(String name, Scanner scanner) {
        System.out.println("Find the greatest common divisor of given numbers.");

        int correctAnswers = 0;
        final int roundsToWin = 3;

        while (correctAnswers < roundsToWin) {
            int num1 = generateRandomNumber(MIN_NUM, MAX_NUM);
            int num2 = generateRandomNumber(MIN_NUM, MAX_NUM);
            int gcd = calculateGCD(num1, num2);

            System.out.println("Question: " + num1 + " " + num2);
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == gcd) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                informUserAboutWrongAnswer(userAnswer, correctAnswers, name);
                return;
            }
        }
        congratulatePlayer(name);

    }

    public static void runProgressionGame(String name, Scanner scanner) {
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
                informUserAboutWrongAnswer(userAnswer, correctAnswers, name);
                return;
            }
        }
        congratulatePlayer(name);

    }

    public static void runPrimeGame(String name, Scanner scanner) {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        int correctAnswers = 0;
        final int roundsToWin = 3;

        while (correctAnswers < roundsToWin) {
            int number = generateRandomNumber(MIN_NUM, MAX_NUM);
            boolean isPrime = isPrimeNumber(number);

            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if ((isPrime && userAnswer.equals("yes")) || (!isPrime && userAnswer.equals("no"))) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                informUserAboutWrongAnswer(userAnswer, correctAnswers, name);
                return;
            }

        }
        congratulatePlayer(name);

    }

    public static String getPlayerName(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public static void congratulatePlayer(String name) {
        System.out.println("Congratulations, " + name + "!");
    }

    private static void informUserAboutWrongAnswer(int userAnswer, int correctAnswer, String name) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + name + "!");
    }

    private static void informUserAboutWrongAnswer(String userAnswer, int correctAnswer, String name) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + name + "!");
    }


}

