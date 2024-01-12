package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DailyWeather {
    private String dayOfWeek;
    private String date;
    private double maxTemperature;
    private double minTemperature;
    private double windSpeed;
    private double chanceOfRain;

    public DailyWeather(String date, double maxTemperature, double minTemperature, double windSpeed, double chanceOfRain) {
        this.date = date;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.windSpeed = windSpeed;
        this.chanceOfRain = chanceOfRain;

        // Calculate the day of the week from the date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        this.dayOfWeek = localDate.getDayOfWeek().toString();
    }

    public void display() {
        System.out.println("\nDay: " + dayOfWeek);
        System.out.println("Date: " + date);
        System.out.println("High Temperature: " + maxTemperature + "°C");
        System.out.println("Low Temperature: " + minTemperature + "°C");
        System.out.println("Wind Speed: " + windSpeed + "m/s");
        System.out.println("Chance of Rain: " + chanceOfRain + "%");
    }
}