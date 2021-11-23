package WeatherView.model;

public class ForecastWeather {

    private String data;
    private static String tomorrowsDate = StaticMethods.getTomorrowsDate();
    private static final int dayOneStamp = 0;
    private static final int dayTwoStamp = 86400;
    private static final int dayThreeStamp = 172800;
    private static final int dayFourStamp = 259200;
    private static String dayOneData;
    private static String dayTwoData;
    private static String dayThreeData;
    private static String dayFourData;

    public ForecastWeather(String data) {
        this.data = data;
        this.dayOneData = getForecast(getStartDataStamp(dayOneStamp));
        this.dayTwoData = getForecast(getStartDataStamp(dayTwoStamp));
        this.dayThreeData = getForecast(getStartDataStamp(dayThreeStamp));
        this.dayFourData = getForecast(getStartDataStamp(dayFourStamp));
    }

    private String getTomorrowNoon(){
        return tomorrowsDate + " 12:00:00";
    }

    private String getStartDataStamp(int increment) {
        int intValue = Integer.valueOf(data.substring(data.indexOf(getTomorrowNoon()) + 28, data.indexOf(getTomorrowNoon()) + 38)) + increment;
        return String.valueOf(intValue);
    }

    private String getForecastEnd(String thisDay) {
        int intValue = Integer.valueOf(thisDay) + 10800;
        return String.valueOf(intValue);
    }

   private String getForecast(String thisDay) {
        return data.substring(data.indexOf(thisDay), data.indexOf(getForecastEnd(thisDay)));
    }

    public String returnRequiredData(int day){
        String requiredDayData = "";
        switch(day){
            case 1: requiredDayData = dayOneData; break;
            case 2: requiredDayData = dayTwoData; break;
            case 3: requiredDayData = dayThreeData; break;
            case 4: requiredDayData = dayFourData; break;
        }
        return requiredDayData;
    }
}

