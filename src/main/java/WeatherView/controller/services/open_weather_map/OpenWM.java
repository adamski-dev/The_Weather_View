package WeatherView.controller.services.open_weather_map;

import WeatherView.config.Config;

public class OpenWM {

    private final String actualBase = "http://api.openweathermap.org/data/2.5/weather?q=";
    private final String forecastBase = "http://api.openweathermap.org/data/2.5/forecast?q=";

    private final String UNITS = "metric";
    private String actualWeatherCall;
    private String forecastWeatherCall;


    public String getActualWeatherCall(String city) {
        actualWeatherCall = actualBase + city + "&units=" + UNITS + "&appid=" + Config.getAPI_KEY();
        return actualWeatherCall;
    }

    public String getForecastWeatherCall(String city){
        forecastWeatherCall = forecastBase + city + "&units=" + UNITS + "&appid=" + Config.getAPI_KEY();
        return forecastWeatherCall;
    }


}
