package WeatherView.controller.services.open_weather_map;

import WeatherView.config.Config;

public class OpenWM {

    private static final String ACTUAL_BASE = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String FORECAST_BASE = "http://api.openweathermap.org/data/2.5/forecast?q=";
    private static final String UNITS = "metric";
    


    public String getActualWeatherCall(String city) {
        return ACTUAL_BASE + city + "&units=" + UNITS + "&appid=" + Config.getAPI_KEY();
    }

    public String getForecastWeatherCall(String city){
        return FORECAST_BASE + city + "&units=" + UNITS + "&appid=" + Config.getAPI_KEY();
    }


}
