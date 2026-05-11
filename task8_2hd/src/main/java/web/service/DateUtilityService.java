package web.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtilityService {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String addDays(String date, int days) {
        LocalDate parsedDate = parseDate(date);
        return parsedDate.plusDays(days).format(FORMATTER);
    }

    public static String subtractDays(String date, int days) {
        LocalDate parsedDate = parseDate(date);
        return parsedDate.minusDays(days).format(FORMATTER);
    }

    public static boolean isCorrectFutureDateAnswer(String startDate, int days, String userAnswer) {
        if (userAnswer == null || userAnswer.trim().isEmpty()) {
            return false;
        }

        String correctAnswer = addDays(startDate, days);
        return correctAnswer.equals(userAnswer.trim());
    }

    public static boolean isCorrectPastDateAnswer(String startDate, int days, String userAnswer) {
        if (userAnswer == null || userAnswer.trim().isEmpty()) {
            return false;
        }

        String correctAnswer = subtractDays(startDate, days);
        return correctAnswer.equals(userAnswer.trim());
    }

    private static LocalDate parseDate(String date) {
        if (date == null || date.trim().isEmpty()) {
            throw new IllegalArgumentException("Date cannot be empty");
        }

        try {
            return LocalDate.parse(date.trim(), FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Date must be in yyyy-MM-dd format");
        }
    }
}