package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ahsan Habib
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

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("january1ShouldIncrementToJanuary2 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(2, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("january1ShouldDecrementToDecember31 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}
	
	@Test
	public void testMinFebruary1ShouldDecrementToJanuary31() {
		DateUtil date = new DateUtil(1, 2, 2024);
		System.out.println("february1ShouldDecrementToJanuary31 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testFebruary28ShouldIncrementToFebruary29InLeapYear() {
		DateUtil date = new DateUtil(28, 2, 2024);
		System.out.println("february28ShouldIncrementToFebruary29 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMaxFebruary29ShouldIncrementToMarch1() {
		DateUtil date = new DateUtil(29, 2, 2024);
		System.out.println("february29ShouldIncrementToMarch1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(3, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMaxFebruary29ShouldDecrementToFebruary28() {
		DateUtil date = new DateUtil(29, 2, 2024);
		System.out.println("february29ShouldDecrementToFebruary28 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(28, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMinMarch1ShouldDecrementToFebruary29() {
		DateUtil date = new DateUtil(1, 3, 2024);
		System.out.println("march1ShouldDecrementToFebruary29 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMaxMarch31ShouldIncrementToApril1() {
		DateUtil date = new DateUtil(31, 3, 2024);
		System.out.println("march31ShouldIncrementToApril1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(4, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMinApril1ShouldDecrementToMarch31() {
		DateUtil date = new DateUtil(1, 4, 2024);
		System.out.println("april1ShouldDecrementToMarch31 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(3, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMaxApril30ShouldIncrementToMay1() {
		DateUtil date = new DateUtil(30, 4, 2024);
		System.out.println("april30ShouldIncrementToMay1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(5, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMaxJune30ShouldIncrementToJuly1() {
		DateUtil date = new DateUtil(30, 6, 2024);
		System.out.println("june30ShouldIncrementToJuly1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(7, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMaxSeptember30ShouldIncrementToOctober1() {
		DateUtil date = new DateUtil(30, 9, 2024);
		System.out.println("september30ShouldIncrementToOctober1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(10, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMaxNovember30ShouldIncrementToDecember1() {
		DateUtil date = new DateUtil(30, 11, 2024);
		System.out.println("november30ShouldIncrementToDecember1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMinDecember1ShouldDecrementToNovember30() {
		DateUtil date = new DateUtil(1, 12, 2024);
		System.out.println("december1ShouldDecrementToNovember30 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(11, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMaxDecember31ShouldIncrementToJanuary1NextYear() {
		DateUtil date = new DateUtil(31, 12, 2024);
		System.out.println("december31ShouldIncrementToJanuary1NextYear > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2025, date.getYear());
	}
	
	@Test
	public void testMaxDecember31ShouldDecrementToDecember30() {
		DateUtil date = new DateUtil(31, 12, 2024);
		System.out.println("december31ShouldDecrementToDecember30 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
}