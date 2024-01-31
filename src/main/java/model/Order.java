package model;


/**
 * this class is model order
 */

public class Order {
    /**
     * model class has food,Customer, and restaurant states
     */

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

    public Order(Food food, Customer customer, Restaurant restaurant) {
        this.food = food;
        this.customer = customer;
        this.restaurant = food.getRestaurant();
    }
}
