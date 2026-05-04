package web.functional;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationAndLoginSeleniumTest {

    private static final String CHROME_DRIVER_PATH = "/usr/local/bin/chromedriver";
    private static final String REGISTER_URL = "http://localhost:8080/register.html";
    private static final String LOGIN_URL = "http://localhost:8080/login.html";

    private WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        return new ChromeDriver();
    }

    @Test
    public void testRegistrationThenLogin() throws InterruptedException {

        WebDriver driver = createDriver();

        try {
            /*
             * Step 1: Open registration page
             */
            driver.get(REGISTER_URL);
            Thread.sleep(1000);

            /*
             * Step 2: Fill registration form
             */
            driver.findElement(By.id("firstName")).sendKeys("Naman");
            driver.findElement(By.id("lastName")).sendKeys("Dhankhar");
            driver.findElement(By.id("email")).sendKeys("naman@example.com");
            driver.findElement(By.id("phone")).sendKeys("0412345678");
            driver.findElement(By.id("username")).sendKeys("naman123");
            driver.findElement(By.id("password")).sendKeys("password123");
            driver.findElement(By.id("confirmPassword")).sendKeys("password123");

            /*
             * Step 3: Submit registration form
             */
            driver.findElement(By.id("registerButton")).click();
            Thread.sleep(3000);

            /*
             * Step 4: Verify registration result
             */
            String registrationPageSource = driver.getPageSource();
            assertTrue(registrationPageSource.contains("Registration successful"));

            /*
             * Step 5: Open login page after registration
             */
            driver.get(LOGIN_URL);
            Thread.sleep(1000);

            /*
             * Step 6: Fill login form
             */
            driver.findElement(By.id("username")).sendKeys("naman123");
            driver.findElement(By.id("password")).sendKeys("password123");

            /*
             * Step 7: Submit login form
             */
            driver.findElement(By.id("loginButton")).click();
            Thread.sleep(3000);

            /*
             * Step 8: Verify login result
             */
            String loginPageSource = driver.getPageSource();
            assertTrue(loginPageSource.contains("Login successful"));

            /*
             * Step 9: Keep final result visible for screenshot
             */
            Thread.sleep(5000);

        } finally {
            driver.quit();
        }
    }
}