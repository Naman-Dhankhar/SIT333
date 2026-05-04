package sit707_week6;

import static org.junit.Assert.*;
import org.junit.Test;
public class DiscountCalculatorTest {

    DiscountCalculator calculator = new DiscountCalculator();

    @Test
    public void testStudentIDIsNotEmpty() {
        String studentID = "225145286";
        assertFalse(studentID.isEmpty());
    }

    @Test
    public void testStudentNameIsNotEmpty() {
        String name = "Naman";
        assertFalse(name.isEmpty());
    }

    @Test
    public void testNormalDiscountCalculation() {
        double result = calculator.calculateFinalPrice(100.0, 20.0);
        assertEquals(80.0, result, 0.001);
    }

    @Test
    public void testZeroDiscount() {
        double result = calculator.calculateFinalPrice(100.0, 0.0);
        assertEquals(100.0, result, 0.001);
    }

    @Test
    public void testFullDiscount() {
        double result = calculator.calculateFinalPrice(100.0, 100.0);
        assertEquals(0.0, result, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeOriginalPrice() {
        calculator.calculateFinalPrice(-100.0, 20.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeDiscount() {
        calculator.calculateFinalPrice(100.0, -10.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDiscountMoreThanHundred() {
        calculator.calculateFinalPrice(100.0, 120.0);
    }
}