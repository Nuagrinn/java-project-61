package hexlet.code;

import java.util.Scanner;

import hexlet.code.Utils.QuestionAnswer;


public class GameRunner {

    public static final int NUMBER_OF_QUESTIONS = 3;

    public static void playGame(Scanner scanner, String rules, QuestionAnswer[] questionsAndAnswers) {
        System.out.print("May I have your name? ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println(rules);
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            String question = questionsAndAnswers[i].getQuestion();
            String correctAnswer = questionsAndAnswers[i].getAnswer();

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim();

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }
        scanner.close();
        System.out.println("Congratulations, " + name + "!");
    }

}
