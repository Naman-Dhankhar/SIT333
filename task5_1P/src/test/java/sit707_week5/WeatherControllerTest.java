package sit707_week5;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static double[] hourlyTemperatures;
    private static int totalHours;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("=== setUpBeforeClass ===");

        // Arrange once for all temperature tests
        wController = WeatherController.getInstance();
        totalHours = wController.getTotalHours();
        hourlyTemperatures = new double[totalHours];

        // Read slow hourly values only once and reuse them in all tests
        for (int i = 0; i < totalHours; i++) {
            hourlyTemperatures[i] = wController.getTemperatureForHour(i + 1);
        }
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("=== tearDownAfterClass ===");
        if (wController != null) {
            wController.close();
        }
    }

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
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");

        // Arrange
        double expectedMin = hourlyTemperatures[0];
        for (int i = 1; i < totalHours; i++) {
            if (hourlyTemperatures[i] < expectedMin) {
                expectedMin = hourlyTemperatures[i];
            }
        }

        // Act
        double actualMin = wController.getTemperatureMinFromCache();

        // Assert
        Assert.assertEquals(expectedMin, actualMin, 0.0);
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");

        // Arrange
        double expectedMax = hourlyTemperatures[0];
        for (int i = 1; i < totalHours; i++) {
            if (hourlyTemperatures[i] > expectedMax) {
                expectedMax = hourlyTemperatures[i];
            }
        }

        // Act
        double actualMax = wController.getTemperatureMaxFromCache();

        // Assert
        Assert.assertEquals(expectedMax, actualMax, 0.0);
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");

        // Arrange
        double sum = 0;
        for (double temperature : hourlyTemperatures) {
            sum += temperature;
        }
        double expectedAverage = sum / totalHours;

        // Act
        double actualAverage = wController.getTemperatureAverageFromCache();

        // Assert
        Assert.assertEquals(expectedAverage, actualAverage, 0.0001);
    }

    @Test
    public void testTemperaturePersist() {
        /*
         * Remove below comments ONLY for 5.3C task.
         */
//      System.out.println("+++ testTemperaturePersist +++");
//
//      // Initialise controller
//      WeatherController wController = WeatherController.getInstance();
//
//      String persistTime = wController.persistTemperature(10, 19.5);
//      String now = new SimpleDateFormat("H:m:s").format(new Date());
//      System.out.println("Persist time: " + persistTime + ", now: " + now);
//
//      Assert.assertTrue(persistTime.equals(now));
//
//      wController.close();
    }
}