package WeatherView.controller.services.open_weather_map;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class OpenWMTest {

    private static final OpenWM openWM = new OpenWM();
    private static final String ACTUAL_BASE = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String FORECAST_BASE = "http://api.openweathermap.org/data/2.5/forecast?q=";
    private static final String UNITS = "&units=metric";
    private static final String GIVEN_CITY = "Athlone,IE";
    private static final String APPID = "&appid=";

    @Test
    void getActualWeatherCallWillContainSetStringOfData() {

        //given
        String requiredActualWeatherCallContent = getRequiredActualWeatherCallContent();

        //when
        String responseReceived = openWM.getActualWeatherCall("Athlone, IE");

        //then
        assertThat(responseReceived, containsString(requiredActualWeatherCallContent));
    }

    @Test
    void getForecastWeatherCallWillContainSetStringOfData() {

        //given
        String requiredForecastWeatherCallContent = getRequiredForecastWeatherCallContent();

        //when
        String responseReceived = openWM.getForecastWeatherCall("Athlone, IE");

        //then
        assertThat(responseReceived, containsString(requiredForecastWeatherCallContent));
    }

    private String getRequiredActualWeatherCallContent() {
        return ACTUAL_BASE + GIVEN_CITY + UNITS + APPID;
    }

    private String getRequiredForecastWeatherCallContent() {
        return FORECAST_BASE + GIVEN_CITY + UNITS + APPID;
    }
}