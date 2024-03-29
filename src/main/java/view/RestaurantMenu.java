package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

/**
 * this class is for restaurant menu
 * restaurant manager can add food,change address,... from this class
 */

public class RestaurantMenu extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL url = RestaurantLoginMenu.class.getResource("/FXML/RestaurantMenu.fxml");
        AnchorPane anchorPane = FXMLLoader.load(url);
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
    }
}
