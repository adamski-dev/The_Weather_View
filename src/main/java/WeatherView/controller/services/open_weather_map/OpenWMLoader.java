package WeatherView.controller.services.open_weather_map;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class OpenWMLoader {

    private static String actualDataString;
    private static String forecastDataString;
    OpenWM openWM;

    public OpenWMLoader(OpenWM owm) {
        this.openWM = owm;
    }

    private static String writeProviderResponseAsDataString(Reader reader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int integerValue = 0;
        while ((integerValue = reader.read()) >= 0) {
            stringBuilder.append((char) integerValue);
        }
        return stringBuilder.toString();
    }

    private static String getWeatherData(String url) throws IOException {
        InputStream inputStream = new URL(url).openStream();
        String data;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            data = writeProviderResponseAsDataString(bufferedReader);
        } finally {
            inputStream.close();
        }
        return data;
    }

    public String requestActualWeatherDataFromProvider(String city) {
        try {
            actualDataString = getWeatherData(openWM.getActualWeatherCall(city.replace(", ", ",")).replace(" ", "%20"));
        } catch (IOException e) {
            actualDataString = "";
        }
        return actualDataString;
    }

    public String requestForecastWeatherDataFromProvider(String city){
        try {
            forecastDataString = getWeatherData(openWM.getForecastWeatherCall(city.replace(", ", ",")).replace(" ", "%20"));
        } catch (IOException e) {
            forecastDataString = "";
        }
        return forecastDataString;
    }

}
