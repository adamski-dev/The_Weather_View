package WeatherView.controller.services.open_weather_map;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class OpenWMTest {

    private OpenWMStub openWMStub = new OpenWMStub();

    @Test
    void getActualWeatherCallWillContainSetStringOfData() {

        //given
        String requiredActualWeatherCallContent = openWMStub.getRequiredActualWeatherCallContent();

        //when
        String responseReceived = openWMStub.getActualWeatherCall();

        //then
        assertThat(responseReceived, is(requiredActualWeatherCallContent));
    }

    @Test
    void getForecastWeatherCallWillContainSetStringOfData() {

        //given
        String requiredForecastWeatherCallContent = openWMStub.getRequiredForecastWeatherCallContent();

        //when
        String responseReceived = openWMStub.getForecastWeatherCall();

        //then
        assertThat(responseReceived, is(requiredForecastWeatherCallContent));
    }
}