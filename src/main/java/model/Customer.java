package model;

import java.util.ArrayList;
import java.util.List;

/**
 * this class is model customer
 */

public class Customer {

    public static List<Customer> allCustomers = new ArrayList<>();
    public static long idCounter = 0;
    public static Customer currentCustomer = null;
    /**
     * customer class has id,name,password,address,financialBalance,previous orders attributes
     */

    private long id;
    private String name;
    private String password;
    private String address;
    private long financialBalance = 0;
    private List<Order> previousOrders = new ArrayList<>();
    private List<Order> cart = new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPreviousOrders(List<Order> previousOrders) {
        this.previousOrders = previousOrders;
    }

    public void setCart(List<Order> cart) {
        this.cart = cart;
    }

    public List<Order> getPreviousOrders() {
        return previousOrders;
    }

    public List<Order> getCart() {
        return cart;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFinancialBalance(long financialBalance) {
        this.financialBalance = financialBalance;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public long getFinancialBalance() {
        return financialBalance;
    }

    public void changeAddress(String newAddress) {
        this.setAddress(newAddress);
    }

    public List<Order> viewPreviousPurchase() {
        return this.previousOrders;
    }

    public List<Food> showListOfFoods() {
        return Food.getListOfAllFoods();
    }

    /**
     * this method pay for a food if mony is enough
     * @param order
     * @return  this will say purchase is succesful or not
     */

    public boolean payOrder(Order order) {
        long financBalance = this.getFinancialBalance();
        long cost = order.getFood().getCost();
        if (financBalance >= cost) {
            this.setFinancialBalance(financBalance - cost);
            this.previousOrders.add(order);
            order.getFood().getRestaurant().getPreviousOrder().add(order);
            order.getFood().getRestaurant().setFinancialBalance(order.getFood().getRestaurant().getFinancialBalance() + cost);
            return true;
        } else
            return false;
    }

    /**
     * this method update previous order list
     * @param order
     */

    public void addPreviousOrder(Order order) {
        List<Order> previousOrder = this.getPreviousOrders();
        previousOrder.add(order);
        this.setPreviousOrders(previousOrder);
    }

    /**
     * this method increase financialBalance of customer
     * @param increaseValue
     */

    public void increaseFinancialBalance(long increaseValue) {
        long nowFinancialBalance = this.getFinancialBalance();
        this.setFinancialBalance(increaseValue + nowFinancialBalance);
    }

    /**
     * this method is customer constructor
     * @param name
     * @param password
     * @param address
     */


    public Customer(String name, String password, String address) {
        this.id = idCounter;
        idCounter++;
        this.name = name;
        this.password = password;
        this.address = address;
        allCustomers.add(this);
    }

    /**
     * this method print list of all foods in terminal
     */

    public static void showListOfFood() {
        System.out.println("=====================");
        System.out.println("Foodlist:");
        for (int i = 0; i < Food.listOfAllFoods.size(); i++) {
            System.out.print(i + 1);
            System.out.println(
                    " foodname: " + Food.listOfAllFoods.get(i).getName() +
                            " foodcost: " + Food.listOfAllFoods.get(i).getCost() +
                            " restaurantname: " + Food.listOfAllFoods.get(i).getRestaurant().getName());
        }
        System.out.println("=====================");
    }

    /**
     * this method print customer previous orders in terminal
     * @param customer
     */

    public static void showPreviousOrders(Customer customer) {
        System.out.println("=====================");
        System.out.println("previous order");
        for (int i = 0; i < customer.getPreviousOrders().size(); i++) {
            System.out.println(i +
                    " food name " + customer.getPreviousOrders().get(i).getFood().getName() +
                    " food cost " + customer.getPreviousOrders().get(i).getFood().getCost() +
                    " restaurant name " + customer.getPreviousOrders().get(i).getFood().getRestaurant().getName());
        }
        System.out.println("=====================");
    }

    public static void showCart(Customer customer) {
        System.out.println("=====================");
        System.out.println("Food Cart");
        for (int i = 0; i < customer.getCart().size(); i++) {
            System.out.println(i +
                    " food name " + customer.getCart().get(i).getFood().getName() +
                    " food cost " + customer.getCart().get(i).getFood().getCost() +
                    " restaurant name " + customer.getCart().get(i).getFood().getRestaurant().getName());
        }
        System.out.println("=====================");
    }

    /**
     * this method search Customer by ID
     * @param customerId
     * @return
     */

    public static Customer searchCustomertById(long customerId) {
        int index = 0;
        for (int i = 0; i < allCustomers.size(); i++) {
            if (allCustomers.get(i).id == customerId) {
                index = i;
                break;
            }
        }
        return allCustomers.get(index);
    }

    /**
     * this method search customer by name
     * @param customerName
     * @return
     */

    public static Customer searchCustomerByName(String customerName) {
        int index = 0;
        for (int i = 0; i < allCustomers.size(); i++) {
            if ((allCustomers.get(i).name).equals(customerName)) {
                index = i;
                break;
            }
        }
        return allCustomers.get(index);
    }


}
