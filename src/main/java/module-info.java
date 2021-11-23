module WeatherView {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.google.gson;
    requires java.net.http;
    requires org.controlsfx.controls;
    requires owm.japis;

    opens WeatherView to javafx.fxml;
    exports WeatherView;
    exports WeatherView.controller;
    opens WeatherView.controller to javafx.fxml;
    exports WeatherView.view;
    opens WeatherView.view to javafx.fxml;

}