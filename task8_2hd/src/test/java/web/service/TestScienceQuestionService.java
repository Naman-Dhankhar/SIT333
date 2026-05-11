package web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestScienceQuestionService {

    @Test
    public void testCalculateDensityValidValues() {
        assertEquals(4.0, ScienceQuestionService.calculateDensity("80", "20"), 0.01);
    }

    @Test
    public void testCalculateDensityDecimalValues() {
        assertEquals(2.5, ScienceQuestionService.calculateDensity("50", "20"), 0.01);
    }

    @Test
    public void testCorrectDensityAnswer() {
        assertTrue(ScienceQuestionService.isCorrectDensityAnswer("80", "20", "4"));
    }

    @Test
    public void testCorrectDensityAnswerWithDecimal() {
        assertTrue(ScienceQuestionService.isCorrectDensityAnswer("80", "20", "4.0"));
    }

    @Test
    public void testIncorrectDensityAnswer() {
        assertFalse(ScienceQuestionService.isCorrectDensityAnswer("80", "20", "5"));
    }

    @Test
    public void testEmptyAnswer() {
        assertFalse(ScienceQuestionService.isCorrectDensityAnswer("80", "20", ""));
    }

    @Test
    public void testInvalidAnswer() {
        assertFalse(ScienceQuestionService.isCorrectDensityAnswer("80", "20", "abc"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroVolume() {
        ScienceQuestionService.calculateDensity("80", "0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeMass() {
        ScienceQuestionService.calculateDensity("-80", "20");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMass() {
        ScienceQuestionService.calculateDensity("abc", "20");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyVolume() {
        ScienceQuestionService.calculateDensity("80", "");
    }
}