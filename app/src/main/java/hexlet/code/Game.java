package hexlet.code;

import java.util.Scanner;

public abstract class Game {
    protected String playerName;
    protected Scanner scanner;

    public void play() {
        scanner = new Scanner(System.in);

        System.out.print("May I have your name? ");
        playerName = scanner.next();
        System.out.println("Hello, " + playerName + "!");

        showInstructions();
        int correctAnswersCount = 0;

        while (correctAnswersCount < getWinningCondition()) {
            String question = generateQuestion();
            System.out.println("Question: " + question);

            System.out.print("Your answer: ");
            String userAnswer = scanner.next();

            if (checkAnswer(question, userAnswer)) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                handleWrongAnswer(question, userAnswer);
                break;
            }
        }

        if (correctAnswersCount == getWinningCondition()) {
            showCongratulations();
        }

        scanner.close();
    }

    protected abstract void showInstructions();

    protected abstract int getWinningCondition();

    protected abstract String generateQuestion();

    protected abstract boolean checkAnswer(String question, String userAnswer);

    protected abstract void handleWrongAnswer(String question, String userAnswer);

    protected abstract void showCongratulations();
}
