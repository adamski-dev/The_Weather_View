package WeatherView.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StaticMethods {

    private static LocalDate localDate = LocalDate.now();
    private static final DateTimeFormatter ACTUAL_DATE_FORMAT = DateTimeFormatter.ofPattern("E, MMM dd");
    private static final DateTimeFormatter FORECAST_DATE_FORMAT = DateTimeFormatter.ofPattern("E dd");

    public static String getActualDate() {
        return localDate.format(ACTUAL_DATE_FORMAT);
    }
    public static String getTomorrowsDate() {
        return String.valueOf(localDate.plusDays(1L));
    }

    public static String getForecastDate(int forecastDay){
        String forecastDayDate = "";
        switch(forecastDay){
            case 1: forecastDayDate = localDate.plusDays(1L).format(FORECAST_DATE_FORMAT); break;
            case 2: forecastDayDate = localDate.plusDays(2L).format(FORECAST_DATE_FORMAT); break;
            case 3: forecastDayDate = localDate.plusDays(3L).format(FORECAST_DATE_FORMAT); break;
            case 4: forecastDayDate = localDate.plusDays(4L).format(FORECAST_DATE_FORMAT); break;
        }
        return forecastDayDate;
    }

    public static String calculateTemperature(String data) {
        int intValue;
        intValue = (int) (Math.round(Double.valueOf(data.substring(data.indexOf("temp_max") + 10, data.indexOf("pressure") - 2))));
        if (data.length() > 440){
            return String.valueOf(intValue) + "\u00b0";
        } else return "" + String.valueOf(intValue) + "\u00b0" + " C";
    }

    public static String getIcon(String data) {
        String base = "https://openweathermap.org/img/w/";
        return base + data.substring(data.indexOf("icon") + 7, data.indexOf("icon") + 10) + ".png";
    }

    public static String getDescription(String data) {

        if (data.length() > 440){
            String text = data.substring(data.indexOf("description") + 14, data.indexOf("icon") - 3);
            return text = text.substring(0, 1).toUpperCase() + text.substring(1);
        } else {
            return data.substring(data.indexOf("weather") + 28, data.indexOf("description") - 3);
        }
    }

    public static String getFeelsLikeTemperature(String data) {
        int intValue;
        intValue = (int) (Math.round(Double.valueOf(data.substring(data.indexOf("feels_like") + 12, data.indexOf("temp_min") - 2))));
        return "Feels like: " + String.valueOf(intValue) + "\u00b0";
    }

    public static String getPressure(String data) {
        int intValue;
        if (data.length() > 440){
            intValue = Integer.valueOf(data.substring(data.indexOf("pressure") + 10, data.indexOf("humidity") - 2));
            return "Pressure: " + intValue + " hPa";
        } else {
            intValue = Integer.valueOf(data.substring(data.indexOf("pressure") + 10, data.indexOf("sea_level") - 2));
            return "" + intValue + " hPa";
        }
    }

    public static String getWind(String data) {
        int intValue;
        intValue = (int) (Math.round(Double.valueOf(data.substring(data.indexOf("speed") + 7, data.indexOf("deg") - 2))));
        return "Wind: " + intValue + " m/s";
    }

    public static String getHumidity(String data) {
        int intValue;
        intValue = Integer.valueOf(data.substring(data.indexOf("humidity") + 10, data.indexOf("humidity") + 12));
        if (data.length() > 440){
            return "Humidity: " + intValue + " %";
        } else return "" + intValue + " %";
    }

    public static String getActualVisibility(String data) {
        int intValue;
        intValue = (int) ((Math.round(Double.valueOf(data.substring(data.indexOf("visibility") + 12, data.indexOf("wind") - 2)))) / 1000);
        return "Visibility: " + intValue + " km";
    }

}

