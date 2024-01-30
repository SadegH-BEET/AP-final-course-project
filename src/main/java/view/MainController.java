package view;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainController {

    public TextField username;

    public void submit(MouseEvent mouseEvent) {
        if(username.getText().length() < 6){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.showAndWait();
        }
    }
}
