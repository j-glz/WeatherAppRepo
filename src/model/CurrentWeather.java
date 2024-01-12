
package model;

import org.json.JSONArray;
import org.json.JSONObject;

public class CurrentWeather {
    private double temperature;
    private String description;
    private JSONArray hourlyForecast;

    public CurrentWeather(double temperature, String description, JSONArray hourlyForecast) {
        this.temperature = temperature;
        this.description = description;
        this.hourlyForecast = hourlyForecast;
    }

    public void display() {
        System.out.println("Current Weather:");
        System.out.println("Temperature: " + temperature + "°C\nDescription: " + description);

        if (hourlyForecast != null && hourlyForecast.length() > 0) {
            System.out.println("\nHourly Forecast:");

            for (int i = 0; i < hourlyForecast.length(); i++) {
                JSONObject hourForecast = hourlyForecast.getJSONObject(i);
                String time = hourForecast.getString("time");
                double temp = hourForecast.getDouble("temperature");

                System.out.println("Time: " + time + ", Temperature: " + temp + "°C");
            }
        }
    }
}