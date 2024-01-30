package view;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Restaurant;

public class AdminMenuController {


    public TextField nameTextField;
    public TextField passwordPasswordField;
    public TextField addressTextField;
    public TextField managerTextField;


    public void showListOfAllRestaurants(MouseEvent mouseEvent) {
        System.out.println("==============================");
        System.out.println("List of All restaurants:");

        for (int i=0;i< Restaurant.allRestaurants.size();i++){
            System.out.print(i+1);
            System.out.print(" Name: "+Restaurant.allRestaurants.get(i).getName()+
                    "  Password: "+Restaurant.allRestaurants.get(i).getPassword()+
                    "  Manager: "+Restaurant.allRestaurants.get(i).getManager());
            System.out.println();
        }
        System.out.println("==============================");
    }

    public void logOut(MouseEvent mouseEvent) throws Exception {
        new AdminLoginMenu().start(Main.stage);
    }

    public void addNewRestaurant(MouseEvent mouseEvent) {
        String name=nameTextField.getText();
        String password=passwordPasswordField.getText();
        String address=addressTextField.getText();
        String managerName=managerTextField.getText();
        if(name!="" && password!="" && address!="" && managerName!=""){
            Restaurant restaurant=new Restaurant(name,managerName,address,password);

        }
        else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("please fill the blanks");
            alert.showAndWait();
        }
    }
}
