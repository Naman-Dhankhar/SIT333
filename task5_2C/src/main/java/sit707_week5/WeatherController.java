package sit707_week5;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class WeatherController {

    private static WeatherController instance;

    private double[] hourlyTemperatures;
    private Double temperatureMin;
    private Double temperatureMax;
    private Double temperatureAverage;

    private LocalTime currentTime;

    private WeatherController() {
        System.out.println("Creating new weather controller...");
        hourlyTemperatures = new double[24];

        Random random = new Random();

        for (int i = 0; i < hourlyTemperatures.length; i++) {
            hourlyTemperatures[i] = 10 + random.nextDouble() * 20;
        }
    }

    public static WeatherController getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            instance = new WeatherController();
        }

        return instance;
    }

    public static void close() {
        System.out.println("Closing weather controller.");
        instance = null;
    }

    public double getTemperatureForHour(int hour) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return hourlyTemperatures[hour];
    }

    public double getTemperatureMinFromCache() {
        if (temperatureMin == null) {
            temperatureMin = hourlyTemperatures[0];

            for (double temperature : hourlyTemperatures) {
                if (temperature < temperatureMin) {
                    temperatureMin = temperature;
                }
            }
        }

        return temperatureMin;
    }

    public double getTemperatureMaxFromCache() {
        if (temperatureMax == null) {
            temperatureMax = hourlyTemperatures[0];

            for (double temperature : hourlyTemperatures) {
                if (temperature > temperatureMax) {
                    temperatureMax = temperature;
                }
            }
        }

        return temperatureMax;
    }

    public double getTemperatureAverageFromCache() {
        if (temperatureAverage == null) {
            double sum = 0;

            for (double temperature : hourlyTemperatures) {
                sum += temperature;
            }

            temperatureAverage = sum / hourlyTemperatures.length;
        }

        return temperatureAverage;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
    }

    public String persistTemperature(int hour) {
        System.out.println("*** persistTemperature ***");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LocalTime timeToUse;

        if (currentTime != null) {
            timeToUse = currentTime;
        } else {
            timeToUse = LocalTime.now();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        return timeToUse.format(formatter);
    }
}