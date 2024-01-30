package view;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Customer;
import model.Food;
import model.Order;
import model.Restaurant;

public class CustomerMenuController {

    public Text showFiancialBalanceTextField;
    public TextField cartNumberTextFiled;
    public TextField valueTextField;
    public TextField newAddressTextField;
    public TextField foodNameTextField;

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

    public void showListOfFoods(MouseEvent mouseEvent) {
        Customer.showListOfFood();


    }

    public void showListOfPreviousOrders(MouseEvent mouseEvent)
    {
        Customer.showPreviousOrders(Customer.currentCustomer);
    }

    public void showCart(MouseEvent mouseEvent) {
        Customer.showCart(Customer.currentCustomer);
    }

    public void buyFood(MouseEvent mouseEvent) {
        String foodName=foodNameTextField.getText();
        Food food=Food.findFoodByName(foodName);
        if(food != null){
            Restaurant restaurant=food.getRestaurant();
            Order order =new Order(food,Customer.currentCustomer,restaurant);
            if (Customer.currentCustomer.payOrder(order)){
                showFiancialBalanceTextField.setText(String.valueOf(Customer.currentCustomer.getFinancialBalance()));

            }
            else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Not enough money");
                alert.showAndWait();
            }
        }
        else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Food not found!");
            alert.showAndWait();
        }

    }
}
