package hexlet.code;

import java.util.Random;

public class Utils {

    private static Random rand = new Random();
    public static int generateRandomInt(int bound) {
        return rand.nextInt(bound);
    }

    public static int generateRandomInt(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }


    public static final class QuestionAnswer {
        private final String question;
        private final String answer;

        public QuestionAnswer(String questionParam, String answerParam) {
            this.question = questionParam;
            this.answer = answerParam;
        }

        public String getQuestion() {
            return question;
        }

        public String getAnswer() {
            return answer;
        }
    }

}
