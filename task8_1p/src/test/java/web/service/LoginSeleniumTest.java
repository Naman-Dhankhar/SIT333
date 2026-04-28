package web.service;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSeleniumTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();

        // 1. Incorrect login first
        driver.get("http://127.0.0.1:8081/login");
        Thread.sleep(2000);

        driver.findElement(By.name("username")).sendKeys("wronguser");
        driver.findElement(By.name("passwd")).sendKeys("wrongpass");
        js.executeScript("document.getElementById('dob').value='1999-01-01';");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Wait so you can RECORD the incorrect credentials message
        Thread.sleep(5000);

        // 2. Now clear fields and enter correct login
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("passwd")).clear();
        js.executeScript("document.getElementById('dob').value='';");

        Thread.sleep(1000);

        driver.findElement(By.name("username")).sendKeys("naman");
        driver.findElement(By.name("passwd")).sendKeys("naman123");
        js.executeScript("document.getElementById('dob').value='2000-01-01';");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Thread.sleep(3000);

        // 3. Q1: 2 + 3 = 5
        driver.findElement(By.name("number1")).sendKeys("2");
        driver.findElement(By.name("number2")).sendKeys("3");
        driver.findElement(By.name("result")).sendKeys("5");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Thread.sleep(3000);

        // 4. Q2: 7 - 3 = 4
        driver.findElement(By.name("number1")).sendKeys("7");
        driver.findElement(By.name("number2")).sendKeys("3");
        driver.findElement(By.name("result")).sendKeys("4");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Thread.sleep(3000);

        // 5. Q3: 3 * 4 = 12
        driver.findElement(By.name("number1")).sendKeys("3");
        driver.findElement(By.name("number2")).sendKeys("4");
        driver.findElement(By.name("result")).sendKeys("12");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}