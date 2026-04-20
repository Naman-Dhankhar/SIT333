package web.service;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoginUnitTest {

    @Test
    public void testValidLogin() {
        assertTrue(LoginService.login("naman", "naman123", "2000-01-01"));
    }

    @Test
    public void testWrongUsername() {
        assertFalse(LoginService.login("wrong", "naman123", "2000-01-01"));
    }

    @Test
    public void testWrongPassword() {
        assertFalse(LoginService.login("naman", "wrong", "2000-01-01"));
    }

    @Test
    public void testWrongDob() {
        assertFalse(LoginService.login("naman", "naman123", "2001-01-01"));
    }

    @Test
    public void testEmptyFields() {
        assertFalse(LoginService.login("", "", ""));
    }

    @Test
    public void testNullValues() {
        assertFalse(LoginService.login(null, null, null));
    }

    @Test
    public void testInvalidDate() {
        assertFalse(LoginService.login("naman", "naman123", "01-01-2000"));
    }
}