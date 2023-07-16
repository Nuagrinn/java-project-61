package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.print("Your choice: ");
        int gameNumber = Integer.parseInt(scanner.nextLine());

        if (gameNumber == 1) {
            Cli.run();
        } else if (gameNumber == 2) {
            System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

            int correctAnswers = 0;

            while (correctAnswers < 3) {
                int number = random.nextInt(100);
                System.out.println("Question: " + number);
                System.out.print("Your answer: ");
                String answer = scanner.nextLine();

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
        } else if (gameNumber == 3) {
            System.out.println("What is the result of the expression?");

            String[] operators = { "+", "-", "*" };
            int firstNumber, secondNumber;
            String operator;
            int correctResult;

            for (int i = 0; i < 3; i++) {
                firstNumber = random.nextInt(50);
                secondNumber = random.nextInt(50);
                operator = operators[random.nextInt(operators.length)];

                switch (operator) {
                    case "+":
                        correctResult = firstNumber + secondNumber;
                        break;
                    case "-":
                        correctResult = firstNumber - secondNumber;
                        break;
                    case "*":
                        correctResult = firstNumber * secondNumber;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected operator: " + operator);
                }

                System.out.println("Question: " + firstNumber + " " + operator + " " + secondNumber);
                System.out.print("Your answer: ");
                int userAnswer = scanner.nextInt();

                if (userAnswer == correctResult) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctResult + "'.");
                    System.out.println("Let's try again, " + name + "!");
                    return;
                }
            }

            System.out.println("Congratulations, " + name + "!");
        } else if (gameNumber == 4) {
            Game gcdGame = new GCDGame();
            gcdGame.play();
        } else if (gameNumber == 5) {
            Game progressionGame = new ProgressionGame();
            progressionGame.play();
        } else if (gameNumber == 6) {
            Game primeGame = new PrimeGame();
            primeGame.play();
        } else if (gameNumber == 0) {
            System.out.println("Exiting the program. Goodbye!");
        } else {
            System.out.println("Invalid game number. Exiting the program. Goodbye!");
        }

        scanner.close();
    }
}
