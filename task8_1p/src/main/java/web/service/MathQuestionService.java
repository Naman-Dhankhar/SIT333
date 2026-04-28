package web.service;

public class MathQuestionService {

    private static Double getNumber(String value) {
        try {
            if (value == null || value.trim().isEmpty()) {
                return null;
            }
            return Double.parseDouble(value.trim());
        } catch (Exception e) {
            return null;
        }
    }

    public static Double q1Addition(String number1, String number2) {
        Double n1 = getNumber(number1);
        Double n2 = getNumber(number2);

        if (n1 == null || n2 == null) {
            return null;
        }

        return n1 + n2;
    }

    public static Double q2Subtraction(String number1, String number2) {
        Double n1 = getNumber(number1);
        Double n2 = getNumber(number2);

        if (n1 == null || n2 == null) {
            return null;
        }

        return n1 - n2;
    }

    public static Double q3Multiplication(String number1, String number2) {
        Double n1 = getNumber(number1);
        Double n2 = getNumber(number2);

        if (n1 == null || n2 == null) {
            return null;
        }

        return n1 * n2;
    }
}