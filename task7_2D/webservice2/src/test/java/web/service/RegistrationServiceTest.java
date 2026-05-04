package web.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RegistrationServiceTest {

    RegistrationService service = new RegistrationService();

    @Test
    public void testValidRegistration() {

        boolean result = service.register(
                "Naman",
                "Dhankhar",
                "naman@example.com",
                "0412345678",
                "naman123",
                "password123",
                "password123"
        );

        assertTrue(result);
    }

    @Test
    public void testEmptyFirstName() {

        boolean result = service.register(
                "",
                "Dhankhar",
                "naman@example.com",
                "0412345678",
                "naman123",
                "password123",
                "password123"
        );

        assertFalse(result);
    }

    @Test
    public void testEmptyLastName() {

        boolean result = service.register(
                "Naman",
                "",
                "naman@example.com",
                "0412345678",
                "naman123",
                "password123",
                "password123"
        );

        assertFalse(result);
    }

    @Test
    public void testInvalidEmail() {

        boolean result = service.register(
                "Naman",
                "Dhankhar",
                "namanexample.com",
                "0412345678",
                "naman123",
                "password123",
                "password123"
        );

        assertFalse(result);
    }

    @Test
    public void testInvalidPhoneNumber() {

        boolean result = service.register(
                "Naman",
                "Dhankhar",
                "naman@example.com",
                "12345",
                "naman123",
                "password123",
                "password123"
        );

        assertFalse(result);
    }

    @Test
    public void testShortUsername() {

        boolean result = service.register(
                "Naman",
                "Dhankhar",
                "naman@example.com",
                "0412345678",
                "abc",
                "password123",
                "password123"
        );

        assertFalse(result);
    }

    @Test
    public void testShortPassword() {

        boolean result = service.register(
                "Naman",
                "Dhankhar",
                "naman@example.com",
                "0412345678",
                "naman123",
                "123",
                "123"
        );

        assertFalse(result);
    }

    @Test
    public void testPasswordMismatch() {

        boolean result = service.register(
                "Naman",
                "Dhankhar",
                "naman@example.com",
                "0412345678",
                "naman123",
                "password123",
                "wrongpass"
        );

        assertFalse(result);
    }

    @Test
    public void testEmptyConfirmPassword() {

        boolean result = service.register(
                "Naman",
                "Dhankhar",
                "naman@example.com",
                "0412345678",
                "naman123",
                "password123",
                ""
        );

        assertFalse(result);
    }
}