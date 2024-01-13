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

    public static DailyWeather[] parse7DayForecast(String response) {
        JSONObject json = new JSONObject(response);

        JSONObject forecast = json.getJSONObject("forecast");
        JSONObject forecastData = forecast.getJSONObject("forecastdata");

        DailyWeather[] dailyWeatherArray = new DailyWeather[7];

        for (int i = 0; i < 7; i++) {
            JSONObject dayForecast = forecastData.getJSONArray("weather").getJSONObject(i);

            String date = dayForecast.getString("date");
            double maxTemperature = dayForecast.getDouble("maxtemp");
            double minTemperature = dayForecast.getDouble("mintemp");
            double windSpeed = dayForecast.getDouble("windspeed");
            double chanceOfRain = dayForecast.getDouble("precip");

            dailyWeatherArray[i] = new DailyWeather(date, maxTemperature, minTemperature, windSpeed, chanceOfRain);
        }

        return dailyWeatherArray;
    }
}
