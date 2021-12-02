package WeatherView.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StaticMethods {

    private static final DateTimeFormatter ACTUAL_DATE_FORMAT = DateTimeFormatter.ofPattern("E, MMM dd");
    private static final DateTimeFormatter FORECAST_DATE_FORMAT = DateTimeFormatter.ofPattern("E dd");
    private static final String FORECAST_WEATHER_PATTERN = "dt_txt";

    public static String getActualDate() {
        return LocalDate.now().format(ACTUAL_DATE_FORMAT);
    }

    public static String getTomorrowsDate() {
        return String.valueOf(LocalDate.now().plusDays(1));
    }

    public static String getForecastDate(int forecastDay) {
        return LocalDate.now().plusDays(forecastDay).format(FORECAST_DATE_FORMAT);
    }

    public static String calculateTemperature(String data) {
        int intValue;
        intValue = (int) (Math.round(Double.parseDouble(data.substring(data.indexOf("temp_max") + 10, data.indexOf("pressure") - 2))));
        if (data.contains(FORECAST_WEATHER_PATTERN)) {
            return "" + intValue + "\u00b0" + " C";
        } else return intValue + "\u00b0";
    }

    public static String getIcon(String data) {
        String base = "https://openweathermap.org/img/w/";
        return base + data.substring(data.indexOf("icon") + 7, data.indexOf("icon") + 10) + ".png";
    }

    public static String getDescription(String data) {

        if (data.contains(FORECAST_WEATHER_PATTERN)) {
            return data.substring(data.indexOf("weather") + 28, data.indexOf("description") - 3);
        } else {
            String text = data.substring(data.indexOf("description") + 14, data.indexOf("icon") - 3);
            return text.substring(0, 1).toUpperCase() + text.substring(1);
        }
    }

    public static String getFeelsLikeTemperature(String data) {
        int intValue;
        intValue = (int) (Math.round(Double.parseDouble(data.substring(data.indexOf("feels_like") + 12, data.indexOf("temp_min") - 2))));
        return "Feels like: " + intValue + "\u00b0";
    }

    public static String getPressure(String data) {
        int intValue;
        if (data.contains(FORECAST_WEATHER_PATTERN)) {
            intValue = Integer.parseInt(data.substring(data.indexOf("pressure") + 10, data.indexOf("sea_level") - 2));
            return "" + intValue + " hPa";
        } else {
            intValue = Integer.parseInt(data.substring(data.indexOf("pressure") + 10, data.indexOf("humidity") - 2));
            return "Pressure: " + intValue + " hPa";
        }
    }

    public static String getWind(String data) {
        int intValue;
        intValue = (int) (Math.round(Double.parseDouble(data.substring(data.indexOf("speed") + 7, data.indexOf("deg") - 2))));
        return "Wind: " + intValue + " m/s";
    }

    public static String getHumidity(String data) {
        int intValue;
        intValue = Integer.parseInt(data.substring(data.indexOf("humidity") + 10, data.indexOf("humidity") + 12));
        if (data.contains(FORECAST_WEATHER_PATTERN)) {
            return "" + intValue + " %";
        } else return "Humidity: " + intValue + " %";
    }

    public static String getActualVisibility(String data) {
        int intValue;
        intValue = (int) ((Math.round(Double.parseDouble(data.substring(data.indexOf("visibility") + 12, data.indexOf("wind") - 2)))) / 1000);
        return "Visibility: " + intValue + " km";
    }
}