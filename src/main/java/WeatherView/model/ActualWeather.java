package WeatherView.model;

import WeatherView.controller.services.open_weather_map.OpenWM;
import WeatherView.controller.services.open_weather_map.OpenWMLoader;

public class ActualWeather {
	
    private OpenWM owm = new OpenWM();
    private OpenWMLoader openWMLoader = new OpenWMLoader(owm);
    private String data;

    public ActualWeather(String location) {
        this.data = openWMLoader.requestActualWeatherDataFromProvider(location);
    }

    public String getIcon() {
        return StaticMethods.getIcon(data);
    }

    public String getTemperature() {
        return StaticMethods.calculateTemperature(data);
    }

    public String getDescription() {
        return StaticMethods.getDescription(data);
    }

    public String getFeelsLike() {
        return StaticMethods.getFeelsLikeTemperature(data);
    }

    public String getDate() {
        return StaticMethods.getActualDate();
    }

    public String getHumidity() {
        return StaticMethods.getHumidity(data);
    }

    public String getPressure() {
        return StaticMethods.getPressure(data);
    }

    public String getWind() { return StaticMethods.getWind(data); }

    public String getActualVisibility(){
        return StaticMethods.getActualVisibility(data);
    }
}



