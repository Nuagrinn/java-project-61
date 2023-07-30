package hexlet.code;

public class Utils {
    public static int generateRandomNumber(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    static int[] generateArithmeticProgression(int start, int step, int length) {
        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = start + step * i;
        }
        return progression;
    }

    static boolean isEven(int number) {
        return number % 2 == 0;
    }

    static char generateRandomOperator() {
        char[] operators = {'+', '-', '*'};
        return operators[(int) (Math.random() * operators.length)];
    }

    static int calculateExpression(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

    static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    static boolean isPrimeNumber(int number) {
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
