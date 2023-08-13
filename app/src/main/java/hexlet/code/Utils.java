package hexlet.code;

public class Utils {

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
