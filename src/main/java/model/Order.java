package model;

import java.util.List;

public class Order {

    private Food food;
    private Customer customer;
    private Restaurant restaurant;


    public Food getFood() {
        return food;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Order(Food food, Customer customer,Restaurant restaurant) {
        this.food = food;
        this.customer = customer;
        this.restaurant = food.getRestaurant();
    }
}
