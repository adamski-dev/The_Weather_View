package WeatherView.model;

import WeatherView.controller.services.open_weather_map.OpenWMLoader;

public class ActualWeather {

    private final String icon;
    private final String temperature;
    private final String description;
    private final String feelsLikeTemperature;
    private final String date;
    private final String humidity;
    private final String pressure;
    private final String wind;
    private final String visibility;

    public ActualWeather(String location) {
        OpenWMLoader openWMLoader = new OpenWMLoader();
        String data = openWMLoader.requestActualWeatherDataFromProvider(location);
        this.icon = StaticMethods.getIcon(data);
        this.temperature = StaticMethods.calculateTemperature(data);
        this.description = StaticMethods.getDescription(data);
        this.feelsLikeTemperature = StaticMethods.getFeelsLikeTemperature(data);
        this.date = StaticMethods.getActualDate();
        this.humidity = StaticMethods.getHumidity(data);
        this.pressure = StaticMethods.getPressure(data);
        this.wind = StaticMethods.getWind(data);
        this.visibility = StaticMethods.getActualVisibility(data);
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