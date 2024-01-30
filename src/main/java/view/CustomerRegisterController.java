package view;

import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Customer;

public class CustomerRegisterController {
    public Text Textfield;
    public Text passwordField;
    public Text addressField;

    public void moveToMain(MouseEvent mouseEvent) throws Exception {
        new Main().start(Main.stage);
    }

    public void registerCustomer(MouseEvent mouseEvent) throws Exception {
        String name=Textfield.getText();
        String password=passwordField.getText();
        String address=addressField.getText();
        Customer customer=new Customer(name,password,address);
        Customer.currentCustomer=customer;
        new CustomerMenu().start(Main.stage);
    }
}
