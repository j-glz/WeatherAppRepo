package api;

import model.CurrentWeather;
import model.DailyWeather;
import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherDataParser {

    public static CurrentWeather parseCurrentWeather(String response) {
        JSONObject json = new JSONObject(response);

        double currentTemperature = json.getJSONObject("current").getDouble("temperature");
        String currentDescription = json.getJSONArray("weather_descriptions").getString(0);
        JSONArray hourlyForecast = json.getJSONArray("hourly");

        return new CurrentWeather(currentTemperature, currentDescription, hourlyForecast);
    }
}
