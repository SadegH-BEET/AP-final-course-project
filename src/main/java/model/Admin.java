package model;

import java.util.List;

public class Admin {
    private final String name="Sadegh";
    private final String password="1234";

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    public List<Restaurant> showListOfAllRestaurants(){
        return Restaurant.getListOfRestaurants();
    }

}
