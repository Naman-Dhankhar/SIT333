package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSeleniumTest {

    private WebDriver driver;
    private JavascriptExecutor js;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
    }

    private void submitPage() {
        try {
            driver.findElement(By.cssSelector("button")).click();
        } catch (Exception e1) {
            try {
                driver.findElement(By.cssSelector("input[type='submit']")).click();
            } catch (Exception e2) {
                driver.findElement(By.tagName("form")).submit();
            }
        }
    }

    private void setDateValue(String fieldName, String value) {
        WebElement dateField = driver.findElement(By.name(fieldName));
        js.executeScript("arguments[0].value='" + value + "';", dateField);
    }

    private WebElement findAnswerField() {
        try {
            return driver.findElement(By.name("answer"));
        } catch (NoSuchElementException e1) {
            try {
                return driver.findElement(By.cssSelector("input[placeholder*='answer']"));
            } catch (NoSuchElementException e2) {
                return driver.findElement(By.cssSelector("input[type='text']"));
            }
        }
    }

    private void enterAnswer(String value) {
        WebElement answerField = findAnswerField();
        answerField.clear();
        answerField.sendKeys(value);
    }

    private void checkCurrentPage(String expectedUrlPart) {
        if (!driver.getCurrentUrl().contains(expectedUrlPart)) {
            throw new AssertionError(
                    "Expected page " + expectedUrlPart
                            + " but current URL is " + driver.getCurrentUrl()
                            + "\nCurrent page text:\n"
                            + driver.findElement(By.tagName("body")).getText()
            );
        }
    }

    @Test
    public void testCompleteStemGameFlow() throws InterruptedException {

        driver.get("http://127.0.0.1:8081/login");
        Thread.sleep(1500);

        driver.findElement(By.name("username")).sendKeys("naman");
        driver.findElement(By.name("passwd")).sendKeys("naman123");
        setDateValue("dob", "2000-01-01");
        submitPage();
        Thread.sleep(1500);

        checkCurrentPage("/q1");

        driver.findElement(By.name("number1")).sendKeys("2");
        driver.findElement(By.name("number2")).sendKeys("3");
        enterAnswer("5");
        submitPage();
        Thread.sleep(1500);

        checkCurrentPage("/q2");

        driver.findElement(By.name("number1")).sendKeys("7");
        driver.findElement(By.name("number2")).sendKeys("3");
        enterAnswer("4");
        submitPage();
        Thread.sleep(1500);

        checkCurrentPage("/q3");

        driver.findElement(By.name("number1")).sendKeys("3");
        driver.findElement(By.name("number2")).sendKeys("4");
        enterAnswer("12");
        submitPage();
        Thread.sleep(1500);

        checkCurrentPage("/date1");

        enterAnswer("2026-05-21");
        submitPage();
        Thread.sleep(1500);

        checkCurrentPage("/date2");

        enterAnswer("2026-05-04");
        submitPage();
        Thread.sleep(1500);

        checkCurrentPage("/science");

        enterAnswer("4");
        submitPage();
        Thread.sleep(1500);

        checkCurrentPage("/complete");

        WebElement body = driver.findElement(By.tagName("body"));

        if (!body.getText().contains("STEM Game Completed")) {
            throw new AssertionError("Completion page was not reached.");
        }
    }

    @Test
    public void testInvalidLoginShowsError() throws InterruptedException {

        driver.get("http://127.0.0.1:8081/login");
        Thread.sleep(1500);

        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("passwd")).sendKeys("wrong");
        setDateValue("dob", "2000-01-01");

        submitPage();
        Thread.sleep(1500);

        WebElement body = driver.findElement(By.tagName("body"));

        if (!body.getText().contains("Invalid")) {
            throw new AssertionError("Invalid login message was not displayed.");
        }
    }

    @Test
    public void testWrongDateAnswerShowsError() throws InterruptedException {

        driver.get("http://127.0.0.1:8081/date1");
        Thread.sleep(1500);

        enterAnswer("2026-05-20");
        submitPage();
        Thread.sleep(1500);

        WebElement body = driver.findElement(By.tagName("body"));

        if (!body.getText().contains("Wrong answer")) {
            throw new AssertionError("Wrong date answer error was not displayed.");
        }
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}