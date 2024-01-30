package view;

import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Admin;

public class AdminLoginMenucontroller {
    public javafx.scene.control.TextField TextField;
    public javafx.scene.control.PasswordField PasswordField;

    public void moveToMainMenu(MouseEvent mouseEvent) throws Exception {
        new Main().start(Main.stage);
    }

    public void moveToRestaurantLoginMenu(MouseEvent mouseEvent) throws Exception {
        new RestaurantLoginMenu().start(Main.stage);
    }

    public void AdminLogin(MouseEvent mouseEvent) throws Exception {
        String name=TextField.getText();
        String password=PasswordField.getText();
        if(name.equals(Admin.getName()) && password.equals(Admin.getPassword())){
            new AdminMenu().start(Main.stage);

        }
        else {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Wrong password!");
            alert.showAndWait();
        }
    }
}
