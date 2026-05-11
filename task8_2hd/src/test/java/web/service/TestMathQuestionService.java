package web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class TestMathQuestionService {

    @Test
    public void testQ1AdditionValidNumbers() {
        assertEquals(5.0, MathQuestionService.q1Addition("2", "3"), 0.01);
    }

    @Test
    public void testQ1AdditionDecimalNumbers() {
        assertEquals(5.5, MathQuestionService.q1Addition("2.5", "3"), 0.01);
    }

    @Test
    public void testQ1AdditionEmptyInput() {
        assertNull(MathQuestionService.q1Addition("", "3"));
    }

    @Test
    public void testQ1AdditionInvalidInput() {
        assertNull(MathQuestionService.q1Addition("abc", "3"));
    }

    @Test
    public void testQ1AdditionNullInput() {
        assertNull(MathQuestionService.q1Addition(null, "3"));
    }

    @Test
    public void testQ2SubtractionValidNumbers() {
        assertEquals(4.0, MathQuestionService.q2Subtraction("7", "3"), 0.01);
    }

    @Test
    public void testQ2SubtractionNegativeResult() {
        assertEquals(-2.0, MathQuestionService.q2Subtraction("3", "5"), 0.01);
    }

    @Test
    public void testQ2SubtractionEmptyInput() {
        assertNull(MathQuestionService.q2Subtraction("", "3"));
    }

    @Test
    public void testQ2SubtractionInvalidInput() {
        assertNull(MathQuestionService.q2Subtraction("abc", "3"));
    }

    @Test
    public void testQ2SubtractionNullInput() {
        assertNull(MathQuestionService.q2Subtraction(null, "3"));
    }

    @Test
    public void testQ3MultiplicationValidNumbers() {
        assertEquals(12.0, MathQuestionService.q3Multiplication("3", "4"), 0.01);
    }

    @Test
    public void testQ3MultiplicationDecimalNumbers() {
        assertEquals(7.5, MathQuestionService.q3Multiplication("2.5", "3"), 0.01);
    }

    @Test
    public void testQ3MultiplicationByZero() {
        assertEquals(0.0, MathQuestionService.q3Multiplication("5", "0"), 0.01);
    }

    @Test
    public void testQ3MultiplicationInvalidInput() {
        assertNull(MathQuestionService.q3Multiplication("abc", "4"));
    }

    @Test
    public void testQ3MultiplicationEmptyInput() {
        assertNull(MathQuestionService.q3Multiplication("", "4"));
    }

    @Test
    public void testQ3MultiplicationNullInput() {
        assertNull(MathQuestionService.q3Multiplication(null, "4"));
    }
}