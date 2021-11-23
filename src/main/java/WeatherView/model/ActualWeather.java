package WeatherView.model;

public class ActualWeather {

    private String data;

    public ActualWeather(String data) {
        this.data = data;
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



