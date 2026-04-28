package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    @Test
    public void testQ1AdditionValidNumbers() {
        Assert.assertEquals(5.0, MathQuestionService.q1Addition("2", "3"), 0.001);
    }

    @Test
    public void testQ1AdditionDecimalNumbers() {
        Assert.assertEquals(5.5, MathQuestionService.q1Addition("2.5", "3"), 0.001);
    }

    @Test
    public void testQ1AdditionEmptyInput() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q1Addition("", "3")));
    }

    @Test
    public void testQ1AdditionInvalidInput() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q1Addition("abc", "3")));
    }

    @Test
    public void testQ2SubtractionValidNumbers() {
        Assert.assertEquals(4.0, MathQuestionService.q2Subtraction("7", "3"), 0.001);
    }

    @Test
    public void testQ2SubtractionNegativeResult() {
        Assert.assertEquals(-2.0, MathQuestionService.q2Subtraction("3", "5"), 0.001);
    }

    @Test
    public void testQ2SubtractionEmptyInput() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q2Subtraction("", "5")));
    }

    @Test
    public void testQ3MultiplicationValidNumbers() {
        Assert.assertEquals(12.0, MathQuestionService.q3Multiplication("3", "4"), 0.001);
    }

    @Test
    public void testQ3MultiplicationInvalidInput() {
        Assert.assertTrue(Double.isNaN(MathQuestionService.q3Multiplication("hello", "4")));
    }
}