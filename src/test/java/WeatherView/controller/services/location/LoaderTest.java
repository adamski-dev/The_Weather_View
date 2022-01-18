package WeatherView.controller.services.location;

import WeatherView.App;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class LoaderTest {

    @Mock
    private Loader loader;

    @InjectMocks
    private Gson gson;

    private static final String LIST_OF_CITIES_ACCESS_PATH_TEST = "json/city.list.min.test.json";

    @Test
    void getListOfCitiesShouldReturnGivenMapSize() {

        //given
        prepareRequiredDataMap();

        //when
        Map<String, String> listOfCities =  loader.getListOfCities();

        //then
        assertThat(listOfCities.size(), is(2));

    }

    @Test
    void getListOfCitiesShouldReturnGivenMapContent() {

        //given
        prepareRequiredDataMap();

        //when
        Map<String, String> listOfCities =  loader.getListOfCities();
        String location1 = "Tychy, PL";
        String location2 = "Athlone, IE";

        //then
        assertThat(listOfCities.values(), contains(location1, location2));
    }

    private void prepareRequiredDataMap(){

        Type LOCATION_TYPE = new TypeToken<List<Location>>() {}.getType();
        InputStreamReader inputStreamReader = new InputStreamReader(Objects.requireNonNull(App.class.getResourceAsStream(LIST_OF_CITIES_ACCESS_PATH_TEST)), StandardCharsets.UTF_8);
        List<Location> jsonListOfCities = gson.fromJson(inputStreamReader, LOCATION_TYPE);

        given(loader.getListOfCities()).willReturn(
                jsonListOfCities.stream().collect(Collectors.toMap(
                                        Location::getCity,
                                        place -> place.getCity() + ", " + place.getCountry(),
                                        (a1, a2) -> a1 )));
    }
}