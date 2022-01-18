package WeatherView.model;


public class ActualWeatherStub {

    private final String icon;
    private final String temperature;
    private final String description;
    private final String feelsLikeTemperature;
    private final String date;
    private final String humidity;
    private final String pressure;
    private final String wind;
    private final String visibility;
    private static final String ACTUAL_WEATHER_DATA_SAMPLE = "{\"coord\":{\"lon\":-7.95,\"lat\":53.4333},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"base\":\"stations\",\"main\":{\"temp\":2.45,\"feels_like\":0.14,\"temp_min\":2.1,\"temp_max\":2.45,\"pressure\":1040,\"humidity\":87,\"sea_level\":1040,\"grnd_level\":1036},\"visibility\":10000,\"wind\":{\"speed\":2.24,\"deg\":183,\"gust\":3.71},\"clouds\":{\"all\":3},\"dt\":1642072352,\"sys\":{\"type\":2,\"id\":2035516,\"country\":\"IE\",\"sunrise\":1642063283,\"sunset\":1642091943},\"timezone\":0,\"id\":2966839,\"name\":\"Athlone\",\"cod\":200}";

    public ActualWeatherStub() {

        this.icon = StaticMethods.getIcon(ACTUAL_WEATHER_DATA_SAMPLE );
        this.temperature = StaticMethods.calculateTemperature(ACTUAL_WEATHER_DATA_SAMPLE );
        this.description = StaticMethods.getDescription(ACTUAL_WEATHER_DATA_SAMPLE );
        this.feelsLikeTemperature = StaticMethods.getFeelsLikeTemperature(ACTUAL_WEATHER_DATA_SAMPLE );
        this.date = StaticMethods.getActualDate();
        this.humidity = StaticMethods.getHumidity(ACTUAL_WEATHER_DATA_SAMPLE );
        this.pressure = StaticMethods.getPressure(ACTUAL_WEATHER_DATA_SAMPLE );
        this.wind = StaticMethods.getWind(ACTUAL_WEATHER_DATA_SAMPLE );
        this.visibility = StaticMethods.getActualVisibility(ACTUAL_WEATHER_DATA_SAMPLE );
    }

    public String getIcon() {
        return icon;
    }
    public String getTemperature() {
        return temperature;
    }
    public String getDescription() {
        return description;
    }
    public String getFeelsLike() {
        return feelsLikeTemperature;
    }
    public String getDate() {
        return date;
    }
    public String getHumidity() {
        return humidity;
    }
    public String getPressure() {
        return pressure;
    }
    public String getWind() {
        return wind;
    }
    public String getActualVisibility() {
        return visibility;
    }
}
