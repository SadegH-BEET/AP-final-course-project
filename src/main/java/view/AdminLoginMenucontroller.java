package view;

import javafx.scene.input.MouseEvent;

public class AdminLoginMenucontroller {
    public void moveToMainMenu(MouseEvent mouseEvent) throws Exception {
        new Main().start(Main.stage);
    }

    public void moveToRestaurantLoginMenu(MouseEvent mouseEvent) throws Exception {
        new RestaurantLoginMenu().start(Main.stage);
    }
}
