public class WeatherApiService {

    private static final String API_KEY = "YOUR_WEATHERSTACK_API_KEY";
    private static final String API_URL = "http://api.weatherstack.com/current";
    private static final String FORECAST_API_URL = "http://api.weatherstack.com/forecast";

    public static String buildApiUrl(String cityName) {
        return API_URL + "?access_key=" + API_KEY + "&query=" + cityName;
    }

    public static String buildForecastApiUrl(String cityName) {
        return FORECAST_API_URL + "?access_key=" + API_KEY + "&query=" + cityName + "&forecast_days=7";
    }

    public static String makeApiRequest(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            StringBuilder response = new StringBuilder();

            int charRead;
            char[] buffer = new char[1024];

            while ((charRead = reader.read(buffer)) != -1) {
                response.append(buffer, 0, charRead);
            }

            reader.close();
            return response.toString();
        } else {
            throw new IOException("Failed to fetch data from the API. Response code: " + responseCode);
        }
    }
}
