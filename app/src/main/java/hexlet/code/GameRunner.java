package hexlet.code;

import java.util.Scanner;


public class GameRunner {

    public static final int NUMBER_OF_QUESTIONS = 3;

    public static void playGame(String rules, String[][] questionsAndAnswers) {
        Scanner innerScanner = new Scanner(System.in);
        System.out.print("May I have your name? ");
        String name = innerScanner.nextLine();

        System.out.println("Hello, " + name + "!");
        System.out.println(rules);

        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            String question = questionsAndAnswers[i][0];
            String correctAnswer = questionsAndAnswers[i][1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = innerScanner.nextLine().trim();

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }
        innerScanner.close();
        System.out.println("Congratulations, " + name + "!");
    }
}
