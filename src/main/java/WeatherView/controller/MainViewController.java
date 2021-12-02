package WeatherView.controller;

import WeatherView.ErrorMessages;
import WeatherView.controller.services.location.Location;
import WeatherView.controller.services.location.Loader;
import WeatherView.model.*;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.layout.VBox;
import org.controlsfx.control.textfield.TextFields;

public class MainViewController extends BaseController implements Initializable {

    private static final int NUMBER_OF_FORECAST_DAYS = 4;
    private final Loader loader;
    private Location location;
    private ActualWeather actualWeather;
    private ForecastWeather forecastWeather;

    public MainViewController(String fxml) {
        super(fxml);
        loader = new Loader(new Gson());
    }

    @FXML
    private Label actualLocation;
    @FXML
    private Label destinationLocation;

    @FXML
    private ImageView weatherIcon;
    @FXML
    private ImageView destinationWeatherIcon;

    @FXML
    private Label actualTemperature;
    @FXML
    private Label destinationActualTemperature;

    @FXML
    private Label feelsLike;
    @FXML
    private Label destinationFeelsLike;

    @FXML
    private Label weatherDescription;
    @FXML
    private Label destinationWeatherDescription;

    @FXML
    private Label humidity;
    @FXML
    private Label destinationHumidity;

    @FXML
    private Label pressure;
    @FXML
    private Label destinationPressure;

    @FXML
    private Label wind;
    @FXML
    private Label destinationWind;

    @FXML
    private Label visibility;
    @FXML
    private Label destinationVisibility;

    @FXML
    private Label date;
    @FXML
    private Label destinationDate;

    @FXML
    private HBox forecast;
    @FXML
    private HBox destinationForecast;

    @FXML
    private Label generalError;
    @FXML
    private Label destinationGeneralError;

    @FXML
    private TextField locationEntry;
    @FXML
    private TextField destinationEntry;

    @FXML
    void getMyLocation() {
        setLocation();
        clearMyLocationView();
        setUpMyLocationWeatherViews();

    }

    @FXML
    void getMyDestination() {
        setDestination();
        clearDestinationView();
        setUpDestinationWeatherViews();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAvailableLocations();
        loadDefaultCity();
        clearMyLocationView();
        setUpMyLocationWeatherViews();
    }

    private void loadAvailableLocations() {
        TextFields.bindAutoCompletion(locationEntry, loader.getListOfCities().values());
        TextFields.bindAutoCompletion(destinationEntry, loader.getListOfCities().values());
    }

    private void loadDefaultCity() {
        location = new Location("Athlone, IE");
    }

    private void clearMyLocationView() {
        generalError.setText("");
        actualTemperature.setText("");
        actualLocation.setText("");
        feelsLike.setText("");
        weatherDescription.setText("");
        date.setText("");
        weatherIcon.setImage(null);
        humidity.setText("");
        pressure.setText("");
        wind.setText("");
        visibility.setText("");
        forecast.getChildren().clear();
    }

    private void setUpMyLocationWeatherViews() {

        if (location.isValidEntry()) {

            try {
                actualWeather = new ActualWeather(location.getCityAndCountry());
                forecastWeather = new ForecastWeather(location.getCityAndCountry());
                setActualWeatherParameters();
                setForecastWeatherParameters(forecast);

            } catch (Exception e) {
                clearMyLocationView();
                generalError.setText(ErrorMessages.CITY_NOT_FOUND);
            }
        } else {
            if (location.isEmptyFlag()) {
                clearMyLocationView();
                generalError.setText(ErrorMessages.LOCATION_FIELD_EMPTY);
            } else {
                clearMyLocationView();
                generalError.setText(ErrorMessages.CITY_NOT_FOUND);
            }
        }
    }

    private void setActualWeatherParameters() {
        actualLocation.setText(location.getCityAndCountry());
        date.setText(actualWeather.getDate());
        actualTemperature.setText(actualWeather.getTemperature());
        feelsLike.setText(actualWeather.getFeelsLike());
        weatherDescription.setText(actualWeather.getDescription());
        humidity.setText(actualWeather.getHumidity());
        pressure.setText(actualWeather.getPressure());
        wind.setText(actualWeather.getWind());
        visibility.setText(actualWeather.getActualVisibility());
        weatherIcon.setImage(new Image(actualWeather.getIcon()));
    }

    private void setForecastWeatherParameters(HBox forecast) {

        for (int i = 1; i <= NUMBER_OF_FORECAST_DAYS; i++) {

            String oneDayData = forecastWeather.returnRequiredData(i);
            VBox dayVBox = new VBox();

            Label dateLabel = new Label(StaticMethods.getForecastDate(i));
            Label temperatureLabel = new Label(StaticMethods.calculateTemperature(oneDayData));
            Label humidityLabel = new Label(StaticMethods.getHumidity(oneDayData));
            Label descriptionLabel = new Label(StaticMethods.getDescription(oneDayData));
            Label pressureLabel = new Label(StaticMethods.getPressure(oneDayData));

            dateLabel.getStyleClass().add("forecast-date-label");
            descriptionLabel.getStyleClass().add("desc-label");
            temperatureLabel.getStyleClass().add("temp-label");
            humidityLabel.getStyleClass().add("fields");
            pressureLabel.getStyleClass().add("fields");

            dayVBox.getChildren().addAll(
                    dateLabel,
                    new ImageView(new Image(StaticMethods.getIcon(oneDayData))),
                    descriptionLabel,
                    pressureLabel,
                    temperatureLabel,
                    humidityLabel
            );
            forecast.getChildren().add(dayVBox);
            dayVBox.setAlignment(Pos.CENTER);
            forecast.setSpacing(55);
        }
    }

    private void setLocation() {
        location = new Location(locationEntry.getText());
    }

    private void setDestination() {
        location = new Location(destinationEntry.getText());
    }

    private void clearDestinationView() {

        destinationGeneralError.setText("");
        destinationActualTemperature.setText("");
        destinationLocation.setText("");
        destinationFeelsLike.setText("");
        destinationWeatherDescription.setText("");
        destinationDate.setText("");
        destinationWeatherIcon.setImage(null);
        destinationHumidity.setText("");
        destinationPressure.setText("");
        destinationWind.setText("");
        destinationVisibility.setText("");
        destinationForecast.getChildren().clear();
    }

    private void setUpDestinationWeatherViews() {

        if (location.isValidEntry()) {

            try {
                actualWeather = new ActualWeather(location.getCityAndCountry());
                forecastWeather = new ForecastWeather(location.getCityAndCountry());
                setDestinationActualWeatherParameters();
                setForecastWeatherParameters(destinationForecast);

            } catch (Exception e) {
                clearDestinationView();
                destinationGeneralError.setText(ErrorMessages.CITY_NOT_FOUND);
            }
        } else {
            if (location.isEmptyFlag()) {
                clearDestinationView();
                destinationGeneralError.setText(ErrorMessages.LOCATION_FIELD_EMPTY);
            } else {
                clearDestinationView();
                destinationGeneralError.setText(ErrorMessages.CITY_NOT_FOUND);
            }
        }
    }

    private void setDestinationActualWeatherParameters() {

        destinationLocation.setText(location.getCityAndCountry());
        destinationDate.setText(actualWeather.getDate());
        destinationActualTemperature.setText(actualWeather.getTemperature());
        destinationFeelsLike.setText(actualWeather.getFeelsLike());
        destinationWeatherDescription.setText(actualWeather.getDescription());
        destinationHumidity.setText(actualWeather.getHumidity());
        destinationPressure.setText(actualWeather.getPressure());
        destinationWind.setText(actualWeather.getWind());
        destinationVisibility.setText(actualWeather.getActualVisibility());
        destinationWeatherIcon.setImage(new Image(actualWeather.getIcon()));
    }
}