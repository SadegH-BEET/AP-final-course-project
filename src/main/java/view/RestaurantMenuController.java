package view;

import controller.RestaurantController;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Food;
import model.Restaurant;

public class RestaurantMenuController {
    public Text showFinancialBalanceField;
    public TextField foodNameTextField;
    public TextField foodCostTextField;
    public TextField newAddressTextField;

    public void logOut(MouseEvent mouseEvent) throws Exception {
        Restaurant.currentRestaurant=null;
        new Main().start(Main.stage);
    }

    public void showFoodMenu(MouseEvent mouseEvent) {
        Restaurant restaurant=Restaurant.currentRestaurant;
        RestaurantController.printFoodMenu();

    }

    public void showFinancialBalance(MouseEvent mouseEvent) {
        showFinancialBalanceField.setText(String.valueOf(Restaurant.currentRestaurant.getFinancialBalance()));
    }

    public void showPreviousOrder(MouseEvent mouseEvent) {
        RestaurantController.printPreviousOrders();
    }

    public void addNewFood(MouseEvent mouseEvent) {
        String name=foodNameTextField.getText();
        long cost=Long.parseLong(foodCostTextField.getText());
        new Food(name,cost,Restaurant.currentRestaurant);
    }

    public void changeAddress(MouseEvent mouseEvent) {
        String newAddress=newAddressTextField.getText();
        Restaurant.currentRestaurant.setAddress(newAddress);
    }
}
