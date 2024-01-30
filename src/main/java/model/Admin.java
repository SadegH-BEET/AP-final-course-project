package model;

import java.util.List;

public class Admin {
    private static final String name="Sadegh";
    private static final String password="1234";

    public static String getName() {
        return name;
    }

    public static String getPassword() {
        return password;
    }
    public List<Restaurant> showListOfAllRestaurants(){
        return Restaurant.getListOfRestaurants();
    }

}
