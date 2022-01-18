package WeatherView.model;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ActualWeatherTest {

    private ActualWeatherStub actualWeatherStub = new ActualWeatherStub();

    @Test
    void getIcon() {

        //given
        String requiredHtmlDataLink = "https://openweathermap.org/img/w/01d.png";

        //when
        //then
        assertThat(actualWeatherStub.getIcon(), is(requiredHtmlDataLink));
    }

    @Test
    void getTemperature() {

        //given
        String requiredTemperature = "2" + "\u00b0";

        //when
        //then
        assertThat(actualWeatherStub.getTemperature(), is(requiredTemperature));
    }

    @Test
    void getDescription() {

        //given
        String requiredDescription = "Clear sky";

        //when
        //then
        assertThat(actualWeatherStub.getDescription(), is(requiredDescription));
    }

    @Test
    void getFeelsLike() {

        //given
        String requiredFeelsLike = "Feels like: 0" + "\u00b0" ;

        //when
        //then
        assertThat(actualWeatherStub.getFeelsLike(), is(requiredFeelsLike));
    }

    @Test
    void getDate() {

        //given
        String requiredDate = StaticMethods.getActualDate();

        //when
        //then
        assertThat(actualWeatherStub.getDate(), is(requiredDate));
    }

    @Test
    void getHumidity() {

        //given
        String requiredHumidity = "Humidity: 87" + " %";

        //when
        //then
        assertThat(actualWeatherStub.getHumidity(), is(requiredHumidity));
    }

    @Test
    void getPressure() {

        //given
        String requiredPressure = "Pressure: 1040 hPa";

        //when
        //then
        assertThat(actualWeatherStub.getPressure(), is(requiredPressure));

    }

    @Test
    void getWind() {
        //given
        String requiredWind = "Wind: 2 m/s";

        //when
        //then
        assertThat(actualWeatherStub.getWind(), is(requiredWind));
    }

    @Test
    void getActualVisibility() {

        //given
        String requiredVisibility = "Visibility: 10 km";

        //when
        //then
        assertThat(actualWeatherStub.getActualVisibility(), is(requiredVisibility));
    }
}