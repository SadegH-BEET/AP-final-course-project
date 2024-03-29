package view;

import controller.RestaurantController;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Food;
import model.Restaurant;

/**
 * this class is a controller for restaurant menu
 */

public class RestaurantMenuController {
    public Text showFinancialBalanceField;
    public TextField foodNameTextField;
    public TextField foodCostTextField;
    public TextField newAddressTextField;
    public TextField cartNumberTextField;

    public void logOut(MouseEvent mouseEvent) throws Exception {
        Restaurant.currentRestaurant = null;
        new Main().start(Main.stage);
    }

    public void showFinancialBalance(MouseEvent mouseEvent) {
        showFinancialBalanceField.setText(String.valueOf(Restaurant.currentRestaurant.getFinancialBalance()));
    }

    public void showPreviousOrder(MouseEvent mouseEvent) {
        RestaurantController.printPreviousOrders();
    }




    public void addNewFood(MouseEvent mouseEvent) {
        String name = foodNameTextField.getText();
        long cost = Long.parseLong(foodCostTextField.getText());
        Food food = new Food(name, cost, Restaurant.currentRestaurant);
        Restaurant.currentRestaurant.getFoodMennu().add(food);
    }

    public void changeAddress(MouseEvent mouseEvent) {
        if (newAddressTextField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("add new address!");
            alert.showAndWait();
        } else {
            String newAddress = newAddressTextField.getText();
            Restaurant.currentRestaurant.changeAddress(newAddress);
        }

    }

    public void withdrawFinancialBalance(MouseEvent mouseEvent) {
        Restaurant.currentRestaurant.setFinancialBalance(0L);
        showFinancialBalanceField.setText("0");
    }

    public void showFoods(MouseEvent mouseEvent) {

        System.out.println("==============================");
        System.out.println(Restaurant.currentRestaurant.getName() + " restaurant food menu");
        for (int i = 0; i < Restaurant.currentRestaurant.getFoodMennu().size(); i++) {
            System.out.print(i + 1);
            System.out.println(" foodname: " + Restaurant.currentRestaurant.getFoodMennu().get(i).getName() +
                    " cost " + Restaurant.currentRestaurant.getFoodMennu().get(i).getCost());
        }
        System.out.println("==============================");
    }
}
