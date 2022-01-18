package WeatherView.controller.services.open_weather_map;

public class OpenWMStub {

    private static final String ACTUAL_BASE = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String FORECAST_BASE = "http://api.openweathermap.org/data/2.5/forecast?q=";
    private static final String UNITS = "&units=metric";
    private static final String GIVEN_CITY = "Athlone, IE";
    private static final String APPID = "&appid=";

    public String getRequiredActualWeatherCallContent(){
        return ACTUAL_BASE + removeSpaceFromLocationString(GIVEN_CITY) + UNITS + APPID;
    }

    public String getRequiredForecastWeatherCallContent(){
        return FORECAST_BASE + removeSpaceFromLocationString(GIVEN_CITY) + UNITS + APPID;
    }

    public String getActualWeatherCall() {
        return ACTUAL_BASE + removeSpaceFromLocationString(GIVEN_CITY) + UNITS + APPID;
    }

    public String getForecastWeatherCall(){
        return FORECAST_BASE + removeSpaceFromLocationString(GIVEN_CITY) + UNITS + APPID;
    }

    private String removeSpaceFromLocationString(String city){

        return city.replace(", ", ",").replace(" ", "%20");
    }
}
