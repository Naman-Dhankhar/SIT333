package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "YOUR_STUDENT_ID";
        Assert.assertNotNull("225145286", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Naman";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTrueNumberIsEven() {
        Assert.assertTrue(WeatherAndMathUtils.isEven(4));
    }

    @Test
    public void testFalseNumberIsEven() {
        Assert.assertFalse(WeatherAndMathUtils.isEven(3));
    }

    @Test
    public void testPrimeOne() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(1));
    }

    @Test
    public void testPrimeEvenNumber() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(4));
    }

    @Test
    public void testPrimeOddNumber() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(9));
    }

    @Test
    public void testCancelWeatherAdviceDangerousWind() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
    }

    @Test
    public void testCancelWeatherAdviceDangerousRain() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(0.0, 6.1));
    }

    @Test
    public void testCancelWeatherAdviceCombinedCondition() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(50.0, 5.0));
    }

    @Test
    public void testWarnWeatherAdviceWindOnly() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(50.0, 2.0));
    }

    @Test
    public void testWarnWeatherAdviceRainOnly() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(20.0, 4.5));
    }

    @Test
    public void testAllClearWeatherAdvice() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(20.0, 2.0));
    }

    @Test
    public void testBoundaryAllClear() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(45.0, 4.0));
    }

    @Test
    public void testBoundaryDangerousWind() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(70.0, 0.0));
    }

    @Test
    public void testBoundaryDangerousRain() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(0.0, 6.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWindThrowsException() {
        WeatherAndMathUtils.weatherAdvice(-1.0, 2.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeRainThrowsException() {
        WeatherAndMathUtils.weatherAdvice(2.0, -1.0);
    }
}