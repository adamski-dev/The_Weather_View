package WeatherView;

import WeatherView.view.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        MainView mainView = new MainView();
        mainView.showMainView();
    }

}