package WeatherView.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StaticMethodsTest {

    private StaticMethodsStub staticMethodsStub = new StaticMethodsStub();
    private static final String ACTUAL_WEATHER_DATA_SAMPLE = "{\"coord\":{\"lon\":-7.95,\"lat\":53.4333},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"base\":\"stations\",\"main\":{\"temp\":2.45,\"feels_like\":0.14,\"temp_min\":2.1,\"temp_max\":2.45,\"pressure\":1040,\"humidity\":87,\"sea_level\":1040,\"grnd_level\":1036},\"visibility\":10000,\"wind\":{\"speed\":2.24,\"deg\":183,\"gust\":3.71},\"clouds\":{\"all\":3},\"dt\":1642072352,\"sys\":{\"type\":2,\"id\":2035516,\"country\":\"IE\",\"sunrise\":1642063283,\"sunset\":1642091943},\"timezone\":0,\"id\":2966839,\"name\":\"Athlone\",\"cod\":200}";
    private static final String FORECAST_WEATHER_DATA_SAMPLE = "1642086000,\"main\":{\"temp\":3.92,\"feels_like\":2.66,\"temp_min\":3.92,\"temp_max\":6.87,\"pressure\":1040,\"sea_level\":1040,\"grnd_level\":1034,\"humidity\":83,\"temp_kf\":-2.95},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":2},\"wind\":{\"speed\":1.54,\"deg\":192,\"gust\":2.24},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-01-13 15:00:00\"},{\"dt\":";
    private static final DateTimeFormatter ACTUAL_DATE_FORMAT = DateTimeFormatter.ofPattern("E, MMM dd");
    private static final DateTimeFormatter FORECAST_DATE_FORMAT = DateTimeFormatter.ofPattern("E dd");

    @Test
    void getActualDateWillReturnTodaysDateInSetFormat() {

        //given
        String todaysDate = LocalDate.now().format(ACTUAL_DATE_FORMAT);

        //when
        //then
        assertThat(staticMethodsStub.getActualDate(), is(todaysDate));
    }

    @Test
    void getTomorrowsDateWillReturnTomorrowsDate() {

        //given
        String tomorrowsDate = String.valueOf(LocalDate.now().plusDays(1));

        //when
        //then
        assertThat(staticMethodsStub.getTomorrowsDate(), is(tomorrowsDate));
    }

    @Test
    void getForecastDateWillReturnFourForecastDaysInSetFormat() {

        //given
        String firstForecastDay = LocalDate.now().plusDays(1).format(FORECAST_DATE_FORMAT);
        String secondForecastDay = LocalDate.now().plusDays(2).format(FORECAST_DATE_FORMAT);
        String thirdForecastDay = LocalDate.now().plusDays(3).format(FORECAST_DATE_FORMAT);
        String fourthForecastDay = LocalDate.now().plusDays(4).format(FORECAST_DATE_FORMAT);

        //when
        //then
        assertThat(staticMethodsStub.getForecastDate(1), is(firstForecastDay));
        assertThat(staticMethodsStub.getForecastDate(2), is(secondForecastDay));
        assertThat(staticMethodsStub.getForecastDate(3), is(thirdForecastDay));
        assertThat(staticMethodsStub.getForecastDate(4), is(fourthForecastDay));
    }


    @Test
    void calculateTemperatureShouldReturnActualTemperatureWhenActualWeatherDataIsPassed() {

        //given
        String expectedActualTemperature = "2\u00b0";

        //when
        //then
        assertThat(staticMethodsStub.calculateTemperature(ACTUAL_WEATHER_DATA_SAMPLE), is(expectedActualTemperature));
    }

    @Test
    void calculateTemperatureShouldReturnForecastTemperatureWhenForecastWeatherDataIsPassed() {

        //given
        String expectedForecastTemperature = "7\u00b0 C";

        //when
        //then
        assertThat(staticMethodsStub.calculateTemperature(FORECAST_WEATHER_DATA_SAMPLE), is(expectedForecastTemperature));
    }

    @Test
    void calculateTemperatureShouldThrowExceptionWhenDataStringIsEmpty() {

        //given
        //when
        //then
        assertThrows(StringIndexOutOfBoundsException.class, () -> staticMethodsStub.calculateTemperature(""));
    }

    @Test
    void getIconShouldReturnProperHTMLLinkWhenActualWeatherDataIsPassed() {

        //given
        String expectedLink = "https://openweathermap.org/img/w/01d.png";

        //when
        //then
        assertThat(staticMethodsStub.getIcon(ACTUAL_WEATHER_DATA_SAMPLE), is(expectedLink));
    }

    @Test
    void getIconShouldReturnProperHTMLLinkWhenForecastWeatherDataIsPassed() {

        //given
        String expectedLink = "https://openweathermap.org/img/w/01d.png";

        //when
        //then
        assertThat(staticMethodsStub.getIcon(FORECAST_WEATHER_DATA_SAMPLE), is(expectedLink));
    }

    @Test
    void getDescriptionShouldReturnActualWeatherDescriptionForActualWeatherData() {

        //given
        String actualWeatherDescription = "Clear sky";

        //when
        //then
        assertThat(staticMethodsStub.getDescription(ACTUAL_WEATHER_DATA_SAMPLE), is(actualWeatherDescription));
    }

    @Test
    void getDescriptionShouldReturnForecastWeatherDescriptionForForecastWeatherData() {

        //given
        String forecastWeatherDescription = "Clear";

        //when
        //then
        assertThat(staticMethodsStub.getDescription(FORECAST_WEATHER_DATA_SAMPLE), is(forecastWeatherDescription));
    }



    @Test
    void getFeelsLikeTemperatureShouldReturnFeelsLikeTemperatureForActualWeatherData() {

        //given
        String expectedFeelsLikeTemperature = "Feels like: 0\u00b0";

        //when
        //then
        assertThat(staticMethodsStub.getFeelsLikeTemperature(ACTUAL_WEATHER_DATA_SAMPLE), is(expectedFeelsLikeTemperature));
    }

    @Test
    void getFeelsLikeTemperatureShouldReturnFeelsLikeTemperatureForForecastWeatherData() {

        //given
        String expectedFeelsLikeTemperature = "Feels like: 3\u00b0";

        //when
        //then
        assertThat(staticMethodsStub.getFeelsLikeTemperature(FORECAST_WEATHER_DATA_SAMPLE), is(expectedFeelsLikeTemperature));
    }

    @Test
    void getPressureShouldReturnActualWeatherPressureWhenActualWeatherDataIsPassed() {

        //given
        String expectedActualWeatherPressure = "Pressure: 1040 hPa";

        //when
        //then
        assertThat(staticMethodsStub.getPressure(ACTUAL_WEATHER_DATA_SAMPLE), is(expectedActualWeatherPressure));
    }

    @Test
    void getPressureShouldReturnForecastWeatherPressureWhenForecastWeatherDataIsPassed() {

        //given
        String expectedForecastWeatherPressure = "1040 hPa";

        //when
        //then
        assertThat(staticMethodsStub.getPressure(FORECAST_WEATHER_DATA_SAMPLE), is(expectedForecastWeatherPressure));
    }

    @Test
    void getWindShouldReturnWindSpeedWhenActualWeatherDataIsPassed() {

        //given
        String expectedActualWeatherWind = "Wind: 2 m/s";

        //when
        //then
        assertThat(staticMethodsStub.getWind(ACTUAL_WEATHER_DATA_SAMPLE), is(expectedActualWeatherWind));
    }

    @Test
    void getWindShouldReturnWindSpeedWhenForecastWeatherDataIsPassed() {

        //given
        String expectedForecastWeatherWind = "Wind: 2 m/s";

        //when
        //then
        assertThat(staticMethodsStub.getWind(FORECAST_WEATHER_DATA_SAMPLE), is(expectedForecastWeatherWind));
    }

    @Test
    void getHumidityShouldReturnActualHumidityWhenActualWeatherDataIsPassed() {

        //given
        String expectedActualHumidity = "Humidity: 87 %";

        //when
        //then
        assertThat(staticMethodsStub.getHumidity(ACTUAL_WEATHER_DATA_SAMPLE), is(expectedActualHumidity));
    }

    @Test
    void getHumidityShouldReturnForecastHumidityWhenForecastWeatherDataIsPassed() {

        //given
        String expectedForecastHumidity = "83 %";

        //when
        //then
        assertThat(staticMethodsStub.getHumidity(FORECAST_WEATHER_DATA_SAMPLE), is(expectedForecastHumidity));
    }

    @Test
    void getActualVisibilityShouldReturnActualWeatherVisibility() {

        //given
        String expectedActualVisibility = "Visibility: 10 km";

        //when
        //then
        assertThat(staticMethodsStub.getActualVisibility(ACTUAL_WEATHER_DATA_SAMPLE), is(expectedActualVisibility));
    }
}