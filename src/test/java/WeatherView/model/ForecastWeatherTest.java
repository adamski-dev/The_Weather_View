package WeatherView.model;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ForecastWeatherTest {

    ForecastWeatherStub forecastWeatherStub = new ForecastWeatherStub();

    @Test
    void returnRequiredDataShouldReturnDayOneDataForecast() {

        //given
        String dayOneData = "1642086000,\"main\":{\"temp\":3.92,\"feels_like\":2.66,\"temp_min\":3.92,\"temp_max\":6.87,\"pressure\":1040,\"sea_level\":1040,\"grnd_level\":1034,\"humidity\":83,\"temp_kf\":-2.95},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":2},\"wind\":{\"speed\":1.54,\"deg\":192,\"gust\":2.24},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-01-13 15:00:00\"},{\"dt\":";

        //when
        //then
        assertThat(forecastWeatherStub.returnRequiredData(1), is(dayOneData));
    }

    @Test
    void returnRequiredDataShouldReturnDayTwoDataForecast() {

        //given
        String dayTwoData = "1642172400,\"main\":{\"temp\":6.19,\"feels_like\":4.68,\"temp_min\":6.19,\"temp_max\":6.19,\"pressure\":1032,\"sea_level\":1032,\"grnd_level\":1028,\"humidity\":84,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":99},\"wind\":{\"speed\":2.08,\"deg\":124,\"gust\":4.49},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-01-14 15:00:00\"},{\"dt\":";

        //when
        //then
        assertThat(forecastWeatherStub.returnRequiredData(2), is(dayTwoData));

    }

    @Test
    void returnRequiredDataShouldReturnDayThreeDataForecast() {

        //given
        String dayThreeData = "1642258800,\"main\":{\"temp\":7.61,\"feels_like\":5.56,\"temp_min\":7.61,\"temp_max\":7.61,\"pressure\":1020,\"sea_level\":1020,\"grnd_level\":1016,\"humidity\":78,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":3.13,\"deg\":172,\"gust\":8.01},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-01-15 15:00:00\"},{\"dt\":";

        //when
        //then
        assertThat(forecastWeatherStub.returnRequiredData(3), is(dayThreeData));
    }

    @Test
    void returnRequiredDataShouldReturnDayFourDataForecast() {

        //given
        String dayFourData = "1642345200,\"main\":{\"temp\":9.8,\"feels_like\":9.39,\"temp_min\":9.8,\"temp_max\":9.8,\"pressure\":1029,\"sea_level\":1029,\"grnd_level\":1025,\"humidity\":89,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":8},\"wind\":{\"speed\":1.53,\"deg\":54,\"gust\":2.16},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2022-01-16 15:00:00\"},{\"dt\":";

        //when
        //then
        assertThat(forecastWeatherStub.returnRequiredData(4), is(dayFourData));
    }
}