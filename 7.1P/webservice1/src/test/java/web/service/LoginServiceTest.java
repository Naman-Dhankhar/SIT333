package web.service;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginServiceTest {

    private WebDriver driver;

    private final String loginPagePath =
            "file:///Users/namandhankhar/Uni/Deakin/T1%202026/SIT333%20Software%20Testing/7.1P/7.1P-resources/webservice1/pages/login.html";

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void performLogin(String username, String password, String dob) {
        driver.get(loginPagePath);

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);

        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(password);

        // Set date safely for input type="date"
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('dob').value = arguments[0];", dob);

        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    @Test
    public void testLoginSuccess() {
        performLogin("naman", "naman123", "2000-01-01");
        Assert.assertEquals("success", driver.getTitle());
    }

    @Test
    public void testWrongUsername() {
        performLogin("wrong", "naman123", "2000-01-01");
        Assert.assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testWrongPassword() {
        performLogin("naman", "wrongpass", "2000-01-01");
        Assert.assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testWrongDob() {
        performLogin("naman", "naman123", "2001-01-01");
        Assert.assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testAllWrong() {
        performLogin("abc", "xyz", "1999-12-12");
        Assert.assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testEmptyFields() {
        performLogin("", "", "");
        Assert.assertEquals("fail", driver.getTitle());
    }
}