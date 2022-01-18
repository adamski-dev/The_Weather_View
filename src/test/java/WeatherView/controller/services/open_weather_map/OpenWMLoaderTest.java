package WeatherView.controller.services.open_weather_map;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.spy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class OpenWMLoaderTest {

    OpenWMLoader OpenWMLoaderSpy = spy(OpenWMLoader.class);
    private static final String requiredCityData = "Athlone, IE";

    @Test
    void requestActualWeatherDataFromProviderWillReturnDesiredDataWhenCityIsPassed() {

        //given
        //when
        String responseActualData = OpenWMLoaderSpy.requestActualWeatherDataFromProvider(requiredCityData);

        //then
        assertThat(responseActualData, containsString("cod\"" + ":200}"));
        assertThat(responseActualData, containsString("Athlone"));
        assertThat(responseActualData, containsString("IE"));
    }

    @Test
    void requestForecastWeatherDataFromProviderWillReturnDesiredDataWhenCityIsPassed() {

        //given
        //when
        String responseForecastData = OpenWMLoaderSpy.requestForecastWeatherDataFromProvider(requiredCityData);

        //then
        assertThat(responseForecastData, containsString("cod\":\"200"));
        assertThat(responseForecastData, containsString("Athlone"));
        assertThat(responseForecastData, containsString("IE"));
    }
}