package view;

import javafx.scene.input.MouseEvent;
import model.Restaurant;

public class AdminMenuController {
    public void showListOfAllRestaurants(MouseEvent mouseEvent) {
        System.out.println("==============================");
        System.out.println("List of All restaurants:");
        for (int i=0;i< Restaurant.allRestaurants.size();i++){
            System.out.print(i+1);
            System.out.print(" "+Restaurant.allRestaurants.get(i).getName()+"  "+Restaurant.allRestaurants.get(i).getPassword()+"  "+Restaurant.allRestaurants.get(i).getManager());
            System.out.println();
        }
        System.out.println("==============================");
    }
}
