package WeatherView.controller.services.location;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void isValidEntryShouldReturnTrueWhenCorrectFormatOfLocationIsUsed() {
        Location location = new Location("Athlone, IRL");
        assertEquals(true, location.isValidEntry());
    }

    @Test
    void isValidEntryShouldReturnFalseWhenIncorrectFormatOfLocationIsUsed(){
        Location location = new Location("Athlone IRL");
        assertEquals(false, location.isValidEntry());
    }

    @Test
    void isEmptyFlagShouldReturnTrueWhenLocationFieldIsEmpty() {
        Location location = new Location("");
        location.isValidEntry();
        assertEquals(true, location.isEmptyFlag());
    }

    @Test
    void isEmptyFlagShouldReturnFalseWhenLocationFieldIsNotEmpty() {
        Location location = new Location("!");
        location.isValidEntry();
        assertEquals(false, location.isEmptyFlag());
    }

}