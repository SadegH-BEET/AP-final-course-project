package view;

import javafx.scene.input.MouseEvent;

public class RestaurantLoginMenuController {
    public void moveToCustomerLoginMenu(MouseEvent mouseEvent) throws Exception {
        new Main().start(Main.stage);
    }

    public void moveToAdminLoginMenu(MouseEvent mouseEvent) throws Exception {
        new AdminLoginMenu().start(Main.stage);
    }
}
