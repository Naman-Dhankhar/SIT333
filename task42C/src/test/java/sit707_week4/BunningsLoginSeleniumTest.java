package sit707_week4;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BunningsLoginSeleniumTest {

    private WebDriver driver;
    private WebDriverWait wait;

    private static final String BASE_URL = "https://www.bunnings.com.au/login";

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void openLoginPage() {
        driver.get(BASE_URL);

        wait.until(ExpectedConditions.urlContains("login"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("retailLogin")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
    }

    private WebElement findEmailField() {
        By emailLocator = By.xpath("//form[@id='retailLogin']//input[@id='username' and @name='username']");
        return wait.until(ExpectedConditions.elementToBeClickable(emailLocator));
    }

    private WebElement findPasswordField() {
        List<By> locators = List.of(
            By.xpath("//form[@id='retailLogin']//input[@id='password' and @name='password']"),
            By.cssSelector("form#retailLogin input[type='password']")
        );

        for (By locator : locators) {
            try {
                return wait.until(ExpectedConditions.elementToBeClickable(locator));
            } catch (Exception e) {
                // try next locator
            }
        }

        throw new NoSuchElementException("Password field not found.");
    }

    private WebElement findSignInButton() {
        List<By> locators = List.of(
            By.cssSelector("form#retailLogin button[type='submit']"),
            By.xpath("//form[@id='retailLogin']//button[contains(., 'Sign in')]"),
            By.xpath("//form[@id='retailLogin']//button[contains(., 'Sign In')]"),
            By.id("login-submit")
        );

        for (By locator : locators) {
            try {
                return wait.until(ExpectedConditions.elementToBeClickable(locator));
            } catch (Exception e) {
                // try next locator
            }
        }

        throw new NoSuchElementException("Sign in button not found.");
    }

    private void attemptLogin(String email, String password) {
        openLoginPage();

        WebElement emailField = findEmailField();
        WebElement passwordField = findPasswordField();
        WebElement signInButton = findSignInButton();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", emailField);
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.click();
        if (email != null && !email.isEmpty()) {
            emailField.sendKeys(email);
        }

        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", passwordField);
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.click();
        if (password != null && !password.isEmpty()) {
            passwordField.sendKeys(password);
        }

        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", signInButton);
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        js.executeScript("arguments[0].click();", signInButton);
    }

    private boolean isStillOnLoginPage() {
        return driver.getCurrentUrl().contains("/login");
    }

    private boolean pageContainsCommonErrorText() {
        String pageText = driver.getPageSource().toLowerCase();
        return pageText.contains("invalid")
                || pageText.contains("incorrect")
                || pageText.contains("error")
                || pageText.contains("required")
                || pageText.contains("please enter")
                || pageText.contains("wrong");
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "225145286";
        Assert.assertNotNull("Student ID is null", studentId);
        Assert.assertFalse("Student ID is empty", studentId.trim().isEmpty());
    }

    @Test
    public void testStudentName() {
        String studentName = "Naman";
        Assert.assertNotNull("Student name is null", studentName);
        Assert.assertFalse("Student name is empty", studentName.trim().isEmpty());
    }

    // Rule 1: email empty, password empty
    @Test
    public void testEmptyEmailAndEmptyPassword() {
        attemptLogin("", "");
        Assert.assertTrue("Should remain on login page", isStillOnLoginPage());
    }

    // Rule 2: email present, password empty
    @Test
    public void testValidFormatEmailAndEmptyPassword() {
        attemptLogin("fakeuser@example.com", "");
        Assert.assertTrue("Should remain on login page", isStillOnLoginPage());
    }

    // Rule 3: email empty, password present
    @Test
    public void testEmptyEmailAndSomePassword() {
        attemptLogin("", "abc123456");
        Assert.assertTrue("Should remain on login page", isStillOnLoginPage());
    }

    // Rule 4: both entered, but invalid credentials
    @Test
    public void testInvalidEmailAndInvalidPassword() {
        attemptLogin("fakeuser@example.com", "Password123");

        try {
            wait.until(driver -> isStillOnLoginPage() || pageContainsCommonErrorText());
        } catch (TimeoutException e) {
            Assert.fail("Timed out waiting for invalid login result.");
        }

        Assert.assertTrue("Should remain on login page for invalid credentials", isStillOnLoginPage());
    }

    // Rule 5: optional successful login
    // Only use if you have a dedicated safe test account.
    /*
    @Test
    public void testValidCredentials() {
        String realEmail = "YOUR_TEST_EMAIL";
        String realPassword = "YOUR_TEST_PASSWORD";

        attemptLogin(realEmail, realPassword);

        try {
            wait.until(driver -> !driver.getCurrentUrl().contains("/login"));
        } catch (TimeoutException e) {
            Assert.fail("Successful login may have failed, or extra verification/CAPTCHA appeared.");
        }

        Assert.assertFalse("Should leave login page after successful login",
                driver.getCurrentUrl().contains("/login"));
    }
    */
}