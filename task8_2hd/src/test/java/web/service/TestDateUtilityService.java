package web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestDateUtilityService {

    @Test
    public void testAddDaysValidDate() {
        assertEquals("2026-05-21", DateUtilityService.addDays("2026-05-11", 10));
    }

    @Test
    public void testSubtractDaysValidDate() {
        assertEquals("2026-05-04", DateUtilityService.subtractDays("2026-05-11", 7));
    }

    @Test
    public void testAddDaysMonthChange() {
        assertEquals("2026-06-02", DateUtilityService.addDays("2026-05-30", 3));
    }

    @Test
    public void testSubtractDaysMonthChange() {
        assertEquals("2026-04-30", DateUtilityService.subtractDays("2026-05-02", 2));
    }

    @Test
    public void testCorrectFutureDateAnswer() {
        assertTrue(DateUtilityService.isCorrectFutureDateAnswer("2026-05-11", 10, "2026-05-21"));
    }

    @Test
    public void testIncorrectFutureDateAnswer() {
        assertFalse(DateUtilityService.isCorrectFutureDateAnswer("2026-05-11", 10, "2026-05-20"));
    }

    @Test
    public void testCorrectPastDateAnswer() {
        assertTrue(DateUtilityService.isCorrectPastDateAnswer("2026-05-11", 7, "2026-05-04"));
    }

    @Test
    public void testIncorrectPastDateAnswer() {
        assertFalse(DateUtilityService.isCorrectPastDateAnswer("2026-05-11", 7, "2026-05-05"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDateFormat() {
        DateUtilityService.addDays("11-05-2026", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyDate() {
        DateUtilityService.addDays("", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullDate() {
        DateUtilityService.subtractDays(null, 7);
    }
}