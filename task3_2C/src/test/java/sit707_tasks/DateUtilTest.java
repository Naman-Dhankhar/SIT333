package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

/**
 * DateUtil unit tests for SIT333 Task 3.2C
 * Student Name: Naman
 * Student ID: 225145286
 */
public class DateUtilTest {

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

    // -----------------------------
    // Equivalence Class D1: Day 1-28
    // -----------------------------

    @Test
    public void testNormalDayShouldIncrementNormally() {
        DateUtil date = new DateUtil(15, 1, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);

        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testNormalDayShouldDecrementNormally() {
        DateUtil date = new DateUtil(15, 1, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);

        Assert.assertEquals(14, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    // -----------------------------
    // Equivalence Class D4: Day 31
    // 31-day month behaviour
    // -----------------------------

    @Test
    public void testJanuary31ShouldIncrementToFebruary1() {
        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);

        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testJanuary31ShouldDecrementToJanuary30() {
        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);

        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMarch31ShouldIncrementToApril1() {
        DateUtil date = new DateUtil(31, 3, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);

        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(4, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testDecember31ShouldIncrementToJanuary1NextYear() {
        DateUtil date = new DateUtil(31, 12, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);

        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2025, date.getYear());
    }

    @Test
    public void testDecember31ShouldDecrementToDecember30() {
        DateUtil date = new DateUtil(31, 12, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);

        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    // -----------------------------
    // Boundary at start of month/year
    // -----------------------------

    @Test
    public void testJanuary1ShouldIncrementToJanuary2() {
        DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);

        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testJanuary1ShouldDecrementToDecember31PreviousYear() {
        DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);

        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    // -----------------------------
    // February in leap year
    // -----------------------------

    @Test
    public void testFebruary1ShouldDecrementToJanuary31() {
        DateUtil date = new DateUtil(1, 2, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);

        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testFebruary28ShouldIncrementToFebruary29InLeapYear() {
        DateUtil date = new DateUtil(28, 2, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);

        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testFebruary29ShouldIncrementToMarch1InLeapYear() {
        DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);

        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testFebruary29ShouldDecrementToFebruary28InLeapYear() {
        DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);

        Assert.assertEquals(28, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMarch1ShouldDecrementToFebruary29InLeapYear() {
        DateUtil date = new DateUtil(1, 3, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);

        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    // -----------------------------
    // February in non-leap year
    // -----------------------------

    @Test
    public void testFebruary28ShouldIncrementToMarch1InNonLeapYear() {
        DateUtil date = new DateUtil(28, 2, 2023);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);

        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    // -----------------------------
    // 30-day month behaviour
    // -----------------------------

    @Test
    public void testApril30ShouldIncrementToMay1() {
        DateUtil date = new DateUtil(30, 4, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);

        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testJune30ShouldIncrementToJuly1() {
        DateUtil date = new DateUtil(30, 6, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);

        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testSeptember30ShouldIncrementToOctober1() {
        DateUtil date = new DateUtil(30, 9, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);

        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(10, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testNovember30ShouldIncrementToDecember1() {
        DateUtil date = new DateUtil(30, 11, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment: " + date);

        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testDecember1ShouldDecrementToNovember30() {
        DateUtil date = new DateUtil(1, 12, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement: " + date);

        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(11, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    // -----------------------------
    // Invalid input tests
    // -----------------------------

    @Test(expected = RuntimeException.class)
    public void testInvalidDayZeroShouldThrowException() {
        new DateUtil(0, 1, 2024);
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidMonthThirteenShouldThrowException() {
        new DateUtil(1, 13, 2024);
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidApril31ShouldThrowException() {
        new DateUtil(31, 4, 2024);
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidFebruary29InNonLeapYearShouldThrowException() {
        new DateUtil(29, 2, 2023);
    }
}