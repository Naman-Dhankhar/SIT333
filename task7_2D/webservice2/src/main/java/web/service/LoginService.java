package web.service;

public class LoginService {

    public boolean login(String username, String password) {

        if (isEmpty(username)) {
            return false;
        }

        if (isEmpty(password)) {
            return false;
        }

        /*
         * Simple fixed login data for testing.
         * This is enough for this SIT333 task because the purpose is
         * integration testing, unit testing, and Selenium functional testing.
         */
        if (username.equals("naman123") && password.equals("password123")) {
            return true;
        }

        return false;
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}