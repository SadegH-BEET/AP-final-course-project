package view;

import controller.CustomerController;
import controller.RestaurantController;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Customer;
import model.Restaurant;

public class RestaurantLoginMenuController {
    public TextField TextField;
    public PasswordField PasswordField;

    public void moveToCustomerLoginMenu(MouseEvent mouseEvent) throws Exception {
        new Main().start(Main.stage);
    }

    public void moveToAdminLoginMenu(MouseEvent mouseEvent) throws Exception {
        new AdminLoginMenu().start(Main.stage);
    }

    public void submit(MouseEvent mouseEvent) throws Exception {
        //System.out.println(TextField.getText());
        //System.out.println(PasswordField.getText());
        String name=TextField.getText();
        String password=PasswordField.getText();
        Restaurant restaurant=searchNameRestaurant(name);
        if(restaurant!=null){
            new RestaurantMenu().start(Main.stage);
            Restaurant.currentRestaurant=restaurant;

        }
        else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("password is not valid or restaurant is not exist!");
            alert.showAndWait();

        }


    }
    public Restaurant searchNameRestaurant(String name){
        Restaurant restaurant=null;
        for(int i=0 ;i<Restaurant.allRestaurants.size();i++){
            if(Restaurant.allRestaurants.get(i).getName().equals(name))
                restaurant= Restaurant.allRestaurants.get(i);
        }
        return restaurant;
    }

   /* public void submit(MouseEvent mouseEvent) throws Exception {
        String name=TextField.getText();
        String password=PasswordField.getText();
        boolean valid= RestaurantController.isRestaurantValid(name,password);
        if(!valid){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("password is not valid or restaurant is not exist!");
            alert.showAndWait();
        }
        else{
            Restaurant.currentRestaurant =Restaurant.searchRestaurantByName(name);
            new CustomerMenu().start(Main.stage);
        }

    }*/
}
