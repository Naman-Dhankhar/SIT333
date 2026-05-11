package web.service;

public class ScienceQuestionService {

    public static double calculateDensity(String mass, String volume) {
        double m = parsePositiveNumber(mass, "Mass");
        double v = parsePositiveNumber(volume, "Volume");

        if (v == 0) {
            throw new IllegalArgumentException("Volume cannot be zero");
        }

        return m / v;
    }

    public static boolean isCorrectDensityAnswer(String mass, String volume, String userAnswer) {
        if (userAnswer == null || userAnswer.trim().isEmpty()) {
            return false;
        }

        try {
            double correctAnswer = calculateDensity(mass, volume);
            double answer = Double.parseDouble(userAnswer.trim());

            return Math.abs(correctAnswer - answer) < 0.01;
        } catch (Exception e) {
            return false;
        }
    }

    private static double parsePositiveNumber(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty");
        }

        try {
            double number = Double.parseDouble(value.trim());

            if (number < 0) {
                throw new IllegalArgumentException(fieldName + " cannot be negative");
            }

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(fieldName + " must be numeric");
        }
    }
}