package sit707_week5;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class WeatherControllerTest {

    private static WeatherController weatherController;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("*** setUpBeforeClass ***");

        weatherController = WeatherController.getInstance();
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("*** tearDownAfterClass ***");

        WeatherController.close();
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "s225145286";

        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Naman Naman";

        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperaturePersist() {
        System.out.println("*** testTemperaturePersist ***");

        // Arrange
        int hour = 10;
        LocalTime fixedTime = LocalTime.of(10, 30, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        weatherController.setCurrentTime(fixedTime);

        String expectedPersistTime = fixedTime.format(formatter);

        // Act
        String actualPersistTime = weatherController.persistTemperature(hour);

        // Assert
        Assert.assertEquals(expectedPersistTime, actualPersistTime);
    }
}