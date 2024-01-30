package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class RestaurantLoginMenu extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL url=RestaurantLoginMenu.class.getResource("/FXML/RestaurantLoginMenu.fxml");
        AnchorPane anchorPane= FXMLLoader.load(url);
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
    }
}
