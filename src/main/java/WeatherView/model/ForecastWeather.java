package WeatherView.model;

import WeatherView.controller.services.open_weather_map.OpenWMLoader;

public class ForecastWeather {

    private static final String TOMORROWS_DATE = StaticMethods.getTomorrowsDate();
    private static final int DAY_ONE_STAMP = 0;
    private static final int DAY_TWO_STAMP = 86400;
    private static final int DAY_THREE_STAMP = 172800;
    private static final int DAY_FOUR_STAMP = 259200;
    private static final int END_OF_DAY_INCREMENT = 10800;
    private final String dayOneData;
    private final String dayTwoData;
    private final String dayThreeData;
    private final String dayFourData;
    private final String data;

    public ForecastWeather(String location) {
        OpenWMLoader openWMLoader = new OpenWMLoader();
        this.data = openWMLoader.requestForecastWeatherDataFromProvider(location);
        this.dayOneData = getForecast(getStartDataStamp(DAY_ONE_STAMP));
        this.dayTwoData = getForecast(getStartDataStamp(DAY_TWO_STAMP));
        this.dayThreeData = getForecast(getStartDataStamp(DAY_THREE_STAMP));
        this.dayFourData = getForecast(getStartDataStamp(DAY_FOUR_STAMP));
    }

    private String getTomorrowNoon() {
        return TOMORROWS_DATE + " 12:00:00";
    }

    private String getStartDataStamp(int increment) {
        int intValue = Integer.parseInt(data.substring(data.indexOf(getTomorrowNoon()) + 28, data.indexOf(getTomorrowNoon()) + 38)) + increment;
        return String.valueOf(intValue);
    }

    private String getForecastEnd(String thisDay) {
        int intValue = Integer.parseInt(thisDay) + END_OF_DAY_INCREMENT;
        return String.valueOf(intValue);
    }

    private String getForecast(String thisDay) {
        return data.substring(data.indexOf(thisDay), data.indexOf(getForecastEnd(thisDay)));
    }

    public String returnRequiredData(int day) {
        String requiredDayData = "";
        switch (day) {
            case 1:
                requiredDayData = dayOneData;
                break;
            case 2:
                requiredDayData = dayTwoData;
                break;
            case 3:
                requiredDayData = dayThreeData;
                break;
            case 4:
                requiredDayData = dayFourData;
                break;
        }
        return requiredDayData;
    }
}