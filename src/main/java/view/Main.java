package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Data;

import java.net.URL;
import java.util.Scanner;

/**
 * @author Sadegh Mohammadian
 * advance programming course final project
 */

public class Main extends Application {
    public static Stage stage;

    /**
     * this is the main menu of program
     * load and download data occur in this class
     * @param args
     * customer can login from this menu
     */
    public static void main(String[] args) {
        Data.loadData();
        launch(args);
        Data.downLoadData();

    }

    @Override
    public void start(Stage stage) throws Exception {
        Main.stage = stage;
        URL url = Main.class.getResource("/FXML/Main.fxml");
        AnchorPane anchorPane = FXMLLoader.load(url);
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();

    }
}
