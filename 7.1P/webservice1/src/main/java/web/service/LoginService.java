package web.service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class LoginService {

    public static boolean login(String username, String password, String dob) {

        if (username == null || password == null || dob == null) {
            return false;
        }

        username = username.trim();
        password = password.trim();
        dob = dob.trim();

        if (username.isEmpty() || password.isEmpty() || dob.isEmpty()) {
            return false;
        }

        try {
            LocalDate.parse(dob);
        } catch (DateTimeParseException e) {
            return false;
        }

        return "naman".equals(username)
                && "naman123".equals(password)
                && "2000-01-01".equals(dob);
    }
}