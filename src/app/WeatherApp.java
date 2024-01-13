package app;

import api.WeatherApiService;
import api.WeatherDataParser;
import model.CurrentWeather;
import model.DailyWeather;

import java.io.IOException;

    public class WeatherApp {

        private String cityName;
        private String stateAbbreviation;

        public WeatherApp(String cityName, String stateAbbreviation) {
            this.cityName = cityName;
            this.stateAbbreviation = stateAbbreviation;
        }

        public void displayWeather() throws IOException {
            String location = cityName + "," + stateAbbreviation; // Combine city and state for location

            String currentWeatherApiUrl = WeatherApiService.buildApiUrl(location);
            String currentWeatherResponse = WeatherApiService.makeApiRequest(currentWeatherApiUrl);

            // Parse and display current weather
            CurrentWeather currentWeather = WeatherDataParser.parseCurrentWeather(currentWeatherResponse);
            currentWeather.display();

            String forecastApiUrl = WeatherApiService.buildForecastApiUrl(location);
            String forecastResponse = WeatherApiService.makeApiRequest(forecastApiUrl);

            // Parse and display the 7-day forecast
            DailyWeather[] dailyWeatherArray = WeatherDataParser.parse7DayForecast(forecastResponse);
            System.out.println("\n7-Day Forecast:");
            for (DailyWeather dailyWeather : dailyWeatherArray) {
                dailyWeather.display();
            }
        }
    }

