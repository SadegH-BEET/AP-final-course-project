package controller;

import model.Customer;
import model.Restaurant;

public class RestaurantController {
    public static boolean isRestaurantValid(String name, String password) {
        boolean found=false;
        Restaurant restaurant=Restaurant.searchRestaurantByName(name);
        if(restaurant==null)
            found=false;
        else {
            if(restaurant.getPassword().equals(password))
                found=true;
            else
                found=false;
        }
        return found;
    }
    public static Customer searchRestaurantByName(String restaurantName) {
        int index = 0;
        for (int i = 0; i < Restaurant.allRestaurants.size(); i++) {
            if ((Restaurant.allRestaurants.get(i).getName()).equals(restaurantName)) {
                index = i;
                break;
            }
        }
        return Customer.allCustomers.get(index);
    }
}
