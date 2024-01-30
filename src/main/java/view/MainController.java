package view;

import controller.CustomerController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Customer;

public class MainController {


    public TextField textField;
    public PasswordField passwordField;

    public void submit(MouseEvent mouseEvent) throws Exception {
       /* if(textField.getText().length() < 6){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.showAndWait();
        }*/
        String name=textField.getText();
        String password=passwordField.getText();
        boolean valid= CustomerController.isCustomerValid(name,password);
        if(!valid){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("password is not valid or customer is not exist!");
        }
        else{
            new CustomerMenu().start(Main.stage);
            Customer.currentCustomer=CustomerController.searchRestaurantByName(name);
        }

    }

    public void moveToAdminLoginMenu(MouseEvent mouseEvent) throws Exception {
        //Button button= (Button) mouseEvent.getSource();
        new AdminLoginMenu().start(Main.stage);
    }

    public void moveToRestauraantLoginMenu(MouseEvent mouseEvent) throws Exception {
        new RestaurantLoginMenu().start(Main.stage);
    }
}
