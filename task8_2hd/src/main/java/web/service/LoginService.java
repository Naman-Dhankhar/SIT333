package web.service;

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

        return "naman".equals(username)
                && "naman123".equals(password)
                && "2000-01-01".equals(dob);
    }
}