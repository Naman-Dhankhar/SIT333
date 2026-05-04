package web.functional;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSeleniumTest {

    @Test
    public void testSuccessfulLogin() {

    	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://localhost:8080/login.html");

            WebElement username = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("loginButton"));

            username.sendKeys("naman123");
            password.sendKeys("password123");

            loginButton.click();

            String pageSource = driver.getPageSource();

            assertTrue(pageSource.contains("Login successful"));

        } finally {
            driver.quit();
        }
    }

    @Test
    public void testFailedLoginWithWrongPassword() {

        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://localhost:8080/login.html");

            driver.findElement(By.id("username")).sendKeys("naman123");
            driver.findElement(By.id("password")).sendKeys("wrongpass");

            driver.findElement(By.id("loginButton")).click();

            String pageSource = driver.getPageSource();

            assertTrue(pageSource.contains("Login failed"));

        } finally {
            driver.quit();
        }
    }

    @Test
    public void testFailedLoginWithEmptyUsername() {

        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://localhost:8080/login.html");

            driver.findElement(By.id("username")).sendKeys("");
            driver.findElement(By.id("password")).sendKeys("password123");

            driver.findElement(By.id("loginButton")).click();

            String pageSource = driver.getPageSource();

            assertTrue(pageSource.contains("Login failed"));

        } finally {
            driver.quit();
        }
    }
}