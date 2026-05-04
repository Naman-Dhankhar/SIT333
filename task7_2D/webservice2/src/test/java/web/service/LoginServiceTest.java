package web.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LoginServiceTest {

    LoginService service = new LoginService();

    @Test
    public void testValidLogin() {

        boolean result = service.login("naman123", "password123");

        assertTrue(result);
    }

    @Test
    public void testInvalidUsername() {

        boolean result = service.login("wronguser", "password123");

        assertFalse(result);
    }

    @Test
    public void testInvalidPassword() {

        boolean result = service.login("naman123", "wrongpass");

        assertFalse(result);
    }

    @Test
    public void testEmptyUsername() {

        boolean result = service.login("", "password123");

        assertFalse(result);
    }

    @Test
    public void testEmptyPassword() {

        boolean result = service.login("naman123", "");

        assertFalse(result);
    }
}