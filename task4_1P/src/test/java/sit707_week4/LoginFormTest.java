package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 */
public class LoginFormTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "225145286";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Naman";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode() {
        // Arrange

        // Act
        LoginStatus status = LoginForm.login(null, null);

        // Assert
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testFailEmptyUsernameAndWrongPasswordAndDontCareValCode() {
        // Arrange
        String username = null;
        String password = "wrong_pass";

        // Act
        LoginStatus status = LoginForm.login(username, password);

        // Assert
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testFailEmptyUsernameAndCorrectPasswordAndDontCareValCode() {
        // Arrange
        String username = null;
        String password = "ahsan_pass";

        // Act
        LoginStatus status = LoginForm.login(username, password);

        // Assert
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testFailWrongUsernameAndEmptyPasswordAndDontCareValCode() {
        // Arrange
        String username = "wrong_user";
        String password = null;

        // Act
        LoginStatus status = LoginForm.login(username, password);

        // Assert
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testFailWrongUsernameAndWrongPasswordAndDontCareValCode() {
        // Arrange
        String username = "wrong_user";
        String password = "wrong_pass";

        // Act
        LoginStatus status = LoginForm.login(username, password);

        // Assert
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testFailWrongUsernameAndCorrectPasswordAndDontCareValCode() {
        // Arrange
        String username = "wrong_user";
        String password = "ahsan_pass";

        // Act
        LoginStatus status = LoginForm.login(username, password);

        // Assert
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testFailCorrectUsernameAndEmptyPasswordAndDontCareValCode() {
        // Arrange
        String username = "ahsan";
        String password = null;

        // Act
        LoginStatus status = LoginForm.login(username, password);

        // Assert
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testFailCorrectUsernameAndWrongPasswordAndDontCareValCode() {
        // Arrange
        String username = "ahsan";
        String password = "wrong_pass";

        // Act
        LoginStatus status = LoginForm.login(username, password);

        // Assert
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testSuccessCorrectUsernameAndCorrectPassword() {
        // Arrange
        String username = "ahsan";
        String password = "ahsan_pass";

        // Act
        LoginStatus status = LoginForm.login(username, password);

        // Assert
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertEquals("123456", status.getErrorMsg());
    }

    @Test
    public void testFailValidationCodeWhenCodeIsNull() {
        // Arrange
        String code = null;

        // Act
        boolean result = LoginForm.validateCode(code);

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void testFailValidationCodeWhenCodeIsWrong() {
        // Arrange
        String code = "654321";

        // Act
        boolean result = LoginForm.validateCode(code);

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void testSuccessValidationCodeWhenCodeIsCorrect() {
        // Arrange
        String code = "123456";

        // Act
        boolean result = LoginForm.validateCode(code);

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void testFullFlowSuccessLoginAndCorrectValidationCode() {
        // Arrange
        String username = "ahsan";
        String password = "ahsan_pass";

        // Act
        LoginStatus status = LoginForm.login(username, password);
        boolean codeValid = LoginForm.validateCode(status.getErrorMsg());

        // Assert
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertEquals("123456", status.getErrorMsg());
        Assert.assertTrue(codeValid);
    }

    @Test
    public void testFullFlowSuccessLoginAndWrongValidationCode() {
        // Arrange
        String username = "ahsan";
        String password = "ahsan_pass";

        // Act
        LoginStatus status = LoginForm.login(username, password);
        boolean codeValid = LoginForm.validateCode("wrong_code");

        // Assert
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertEquals("123456", status.getErrorMsg());
        Assert.assertFalse(codeValid);
    }
}