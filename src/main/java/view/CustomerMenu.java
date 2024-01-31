package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

/**
 * this class is for customer menu
 * from this menu customer can buy food ,change address,iincrease financial balance,..
 */

public class CustomerMenu extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL url = AdminLoginMenu.class.getResource("/FXML/CustomerMenu.fxml");
        AnchorPane anchorPane = FXMLLoader.load(url);
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);

    }
}
