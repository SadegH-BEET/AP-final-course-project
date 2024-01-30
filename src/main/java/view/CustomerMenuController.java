package view;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Customer;

public class CustomerMenuController {

    public Text showFiancialBalanceTextField;
    public TextField cartNumberTextFiled;
    public TextField valueTextField;
    public TextField newAddressTextField;

    public void logOut(MouseEvent mouseEvent) throws Exception {
        Customer.currentCustomer=null;
        new Main().start(Main.stage);
    }

    public void showFinancialBalance(MouseEvent mouseEvent) {
        showFiancialBalanceTextField.setText(String.valueOf(Customer.currentCustomer.getFinancialBalance()));

    }

    public void increaseFinancialBalance(MouseEvent mouseEvent) {
        long value=Long.parseLong(valueTextField.getText());
        Customer.currentCustomer.increaseFinancialBalance(value);
        showFiancialBalanceTextField.setText(String.valueOf(Customer.currentCustomer.getFinancialBalance()));
    }

    public void changeAddress(MouseEvent mouseEvent) {
        String newAddress=newAddressTextField.getText();
        Customer.currentCustomer.changeAddress(newAddress);
    }
}
