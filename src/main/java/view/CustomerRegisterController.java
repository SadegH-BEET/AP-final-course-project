package view;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Customer;

/**
 * this class is customer register menu controller
 * customer set name,password and address from this menu
 */

public class CustomerRegisterController {

    public TextField ADD;
    public TextField NAME;
    public PasswordField PASS;

    public void moveToMain(MouseEvent mouseEvent) throws Exception {
        new Main().start(Main.stage);
    }

    public void registerCustomer(MouseEvent mouseEvent) throws Exception {
        String name = NAME.getText();
        String password = PASS.getText();
        String address = ADD.getText();
        Customer customer = new Customer(name, password, address);
        Customer.currentCustomer = customer;
        new CustomerMenu().start(Main.stage);
    }
}
