package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

/**
 * this class is for admin menu
 * from this menu admin can add restaurant and see list of all restaurants
 */

public class AdminMenu extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL url = AdminLoginMenu.class.getResource("/FXML/AdminMenu.fxml");
        AnchorPane anchorPane = FXMLLoader.load(url);
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);

    }
}
