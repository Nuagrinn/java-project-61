package hexlet.code;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        int gameNumber = Integer.parseInt(scanner.nextLine());

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();

        switch (gameNumber) {
            case 1:
                Cli.run();
                break;
            case 2:
                playEvenGame(name, scanner);
                break;
            case 3:
                playCalcGame(name, scanner);
                break;
            case 4:
                playGcdGame(name, scanner);
                break;
            case 5:
                playProgressionGame(name, scanner);
                break;
            case 6:
                playPrimeGame(name, scanner);
                break;
            case 0:
                System.out.println("Exiting the program. Goodbye!");
                break;
            default:
                System.out.println("Invalid game number. Exiting the program. Goodbye!");
        }

        scanner.close();
    }

    private static void playEvenGame(String name, Scanner scanner) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        int correctAnswers = 0;

        while (correctAnswers < 3) {
            Random random = new Random();
            int number = random.nextInt(100);
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String answer = scanner.next();

            boolean isEven = number % 2 == 0;
            boolean isCorrect = (isEven && answer.equals("yes")) || (!isEven && answer.equals("no"));

            if (isCorrect) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + (isEven ? "yes" : "no") + "'.");
                System.out.println("Let's try again, " + name + "!");
                correctAnswers = 0;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }

    private static void playCalcGame(String name, Scanner scanner) {
        System.out.println("What is the result of the expression?");
        String[] operators = { "+", "-", "*" };
        int correctAnswers = 0;

        while (correctAnswers < 3) {
            Random random = new Random();
            int firstNumber = random.nextInt(50);
            int secondNumber = random.nextInt(50);
            String operator = operators[random.nextInt(operators.length)];
            int correctResult = calculateExpression(firstNumber, secondNumber, operator);

            System.out.println("Question: " + firstNumber + " " + operator + " " + secondNumber);
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == correctResult) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctResult + "'.");
                System.out.println("Let's try again, " + name + "!");
                correctAnswers = 0;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }

    private static void playGcdGame(String name, Scanner scanner) {
        System.out.println("Find the greatest common divisor of given numbers.");
        int correctAnswers = 0;

        while (correctAnswers < 3) {
            Random random = new Random();
            int number1 = random.nextInt(100) + 1;
            int number2 = random.nextInt(100) + 1;
            int correctAnswer = gcd(number1, number2);

            System.out.println("Question: " + number1 + " " + number2);
            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                correctAnswers = 0;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }

    private static void playProgressionGame(String name, Scanner scanner) {
        System.out.println("What number is missing in the progression?");
        int correctAnswers = 0;

        while (correctAnswers < 3) {
            Random random = new Random();
            int length = random.nextInt(5) + 5;
            int firstNumber = random.nextInt(50);
            int step = random.nextInt(10) + 1;
            int missingIndex = random.nextInt(length);

            int[] progression = new int[length];
            for (int i = 0; i < length; i++) {
                progression[i] = firstNumber + i * step;
            }
            String correctAnswer = Integer.toString(progression[missingIndex]);
            progression[missingIndex] = -1; // Hide the missing number
            String question = Arrays.toString(progression).replaceAll("-1", "..");

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                correctAnswers = 0;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }

    private static void playPrimeGame(String name, Scanner scanner) {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        int correctAnswers = 0;

        while (correctAnswers < 3) {
            Random random = new Random();
            int number = random.nextInt(100) + 1;
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String answer = scanner.next();

            boolean isPrime = isPrime(number);
            boolean isCorrect = (isPrime && answer.equals("yes")) || (!isPrime && answer.equals("no"));

            if (isCorrect) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + (isPrime ? "yes" : "no") + "'.");
                System.out.println("Let's try again, " + name + "!");
                correctAnswers = 0;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }

    private static int calculateExpression(int firstNumber, int secondNumber, String operator) {
        switch (operator) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            default:
                throw new IllegalArgumentException("Unexpected operator: " + operator);
        }
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
