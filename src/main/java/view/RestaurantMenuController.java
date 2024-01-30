package view;

import javafx.scene.input.MouseEvent;
import model.Restaurant;

public class RestaurantMenuController {
    public void logOut(MouseEvent mouseEvent) throws Exception {
        Restaurant.currentRestaurant=null;
        new Main().start(Main.stage);
    }

}
