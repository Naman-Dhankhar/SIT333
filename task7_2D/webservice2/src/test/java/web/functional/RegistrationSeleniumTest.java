package web.functional;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationSeleniumTest {

    private static final String CHROME_DRIVER_PATH = "/usr/local/bin/chromedriver";
    private static final String REGISTER_URL = "http://localhost:8080/register.html";

    private WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        return new ChromeDriver();
    }

    private void pauseBeforeClosing() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Test
    public void testSuccessfulRegistration() throws InterruptedException {

        WebDriver driver = createDriver();

        try {
            driver.get(REGISTER_URL);

            driver.findElement(By.id("firstName")).sendKeys("Naman");
            driver.findElement(By.id("lastName")).sendKeys("Dhankhar");
            driver.findElement(By.id("email")).sendKeys("naman@example.com");
            driver.findElement(By.id("phone")).sendKeys("0412345678");
            driver.findElement(By.id("username")).sendKeys("naman123");
            driver.findElement(By.id("password")).sendKeys("password123");
            driver.findElement(By.id("confirmPassword")).sendKeys("password123");

            driver.findElement(By.id("registerButton")).click();

            pauseBeforeClosing();

            String pageSource = driver.getPageSource();

            assertTrue(pageSource.contains("Registration successful"));

        } finally {
            driver.quit();
        }
    }

    @Test
    public void testRegistrationFailsForPasswordMismatch() throws InterruptedException {

        WebDriver driver = createDriver();

        try {
            driver.get(REGISTER_URL);

            driver.findElement(By.id("firstName")).sendKeys("Naman");
            driver.findElement(By.id("lastName")).sendKeys("Dhankhar");
            driver.findElement(By.id("email")).sendKeys("naman@example.com");
            driver.findElement(By.id("phone")).sendKeys("0412345678");
            driver.findElement(By.id("username")).sendKeys("naman123");
            driver.findElement(By.id("password")).sendKeys("password123");
            driver.findElement(By.id("confirmPassword")).sendKeys("wrongpass");

            driver.findElement(By.id("registerButton")).click();

            pauseBeforeClosing();

            String pageSource = driver.getPageSource();

            assertTrue(pageSource.contains("Registration failed"));

        } finally {
            driver.quit();
        }
    }

    @Test
    public void testRegistrationFailsForEmptyFirstName() throws InterruptedException {

        WebDriver driver = createDriver();

        try {
            driver.get(REGISTER_URL);

            driver.findElement(By.id("firstName")).sendKeys("");
            driver.findElement(By.id("lastName")).sendKeys("Dhankhar");
            driver.findElement(By.id("email")).sendKeys("naman@example.com");
            driver.findElement(By.id("phone")).sendKeys("0412345678");
            driver.findElement(By.id("username")).sendKeys("naman123");
            driver.findElement(By.id("password")).sendKeys("password123");
            driver.findElement(By.id("confirmPassword")).sendKeys("password123");

            driver.findElement(By.id("registerButton")).click();

            pauseBeforeClosing();

            String pageSource = driver.getPageSource();

            assertTrue(pageSource.contains("Registration failed"));

        } finally {
            driver.quit();
        }
    }

    @Test
    public void testRegistrationFailsForInvalidEmail() throws InterruptedException {

        WebDriver driver = createDriver();

        try {
            driver.get(REGISTER_URL);

            driver.findElement(By.id("firstName")).sendKeys("Naman");
            driver.findElement(By.id("lastName")).sendKeys("Dhankhar");
            driver.findElement(By.id("email")).sendKeys("invalidemail");
            driver.findElement(By.id("phone")).sendKeys("0412345678");
            driver.findElement(By.id("username")).sendKeys("naman123");
            driver.findElement(By.id("password")).sendKeys("password123");
            driver.findElement(By.id("confirmPassword")).sendKeys("password123");

            driver.findElement(By.id("registerButton")).click();

            pauseBeforeClosing();

            String pageSource = driver.getPageSource();

            assertTrue(pageSource.contains("Registration failed"));

        } finally {
            driver.quit();
        }
    }

    @Test
    public void testRegistrationFailsForInvalidPhone() throws InterruptedException {

        WebDriver driver = createDriver();

        try {
            driver.get(REGISTER_URL);

            driver.findElement(By.id("firstName")).sendKeys("Naman");
            driver.findElement(By.id("lastName")).sendKeys("Dhankhar");
            driver.findElement(By.id("email")).sendKeys("naman@example.com");
            driver.findElement(By.id("phone")).sendKeys("12345");
            driver.findElement(By.id("username")).sendKeys("naman123");
            driver.findElement(By.id("password")).sendKeys("password123");
            driver.findElement(By.id("confirmPassword")).sendKeys("password123");

            driver.findElement(By.id("registerButton")).click();

            pauseBeforeClosing();

            String pageSource = driver.getPageSource();

            assertTrue(pageSource.contains("Registration failed"));

        } finally {
            driver.quit();
        }
    }
}