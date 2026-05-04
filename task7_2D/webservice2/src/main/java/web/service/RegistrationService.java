package web.service;

public class RegistrationService {

    public boolean register(
            String firstName,
            String lastName,
            String email,
            String phone,
            String username,
            String password,
            String confirmPassword
    ) {

        if (isEmpty(firstName)) {
            return false;
        }

        if (isEmpty(lastName)) {
            return false;
        }

        if (isEmpty(email)) {
            return false;
        }

        if (isEmpty(phone)) {
            return false;
        }

        if (isEmpty(username)) {
            return false;
        }

        if (isEmpty(password)) {
            return false;
        }

        if (isEmpty(confirmPassword)) {
            return false;
        }

        if (!isValidEmail(email)) {
            return false;
        }

        if (!isValidPhone(phone)) {
            return false;
        }

        if (username.length() < 4) {
            return false;
        }

        if (password.length() < 6) {
            return false;
        }

        if (!password.equals(confirmPassword)) {
            return false;
        }

        return true;
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }
}