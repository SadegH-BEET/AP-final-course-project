package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    public static List<Customer> allCustomers=new ArrayList<>();
    public static long idCounter=0;
    public static Customer currentCustomer=null;


    private long id;
    private String name;
    private String password;
    private String address;
    private long financialBalance=0;
    private List<Order> previousOrders=new ArrayList<>();
    private List<Order> cart=new ArrayList<>();

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

    public static Customer searchCustomertById(long customerId)
    {
        int index = 0;
        for (int i = 0; i < allCustomers.size(); i++) {
            if (allCustomers.get(i).id==customerId ){
                index = i;
                break;
            }
        }
        return allCustomers.get(index);
    }


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

    public Customer(String name, String password, String address) {
        this.id=idCounter;
        idCounter++;
        this.name = name;
        this.password = password;
        this.address = address;
        allCustomers.add(this);
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
    public void changeAddress(String newAddress)
    {
        this.setAddress(newAddress);
    }
    public void increaseFinancialBalance(long increaseValue){
        long nowFinancialBalance=this.getFinancialBalance();
        this.setFinancialBalance(increaseValue+nowFinancialBalance);
    }
    public void addPreviousOrder(Order order){
        List<Order> previousOrder= this.getPreviousOrders();
        previousOrder.add(order);
        this.setPreviousOrders(previousOrder);
    }
    public List<Order> viewPreviousPurchase(){
        return this.previousOrders;
    }
    public List<Food> showListOfFoods(){
        return Food.getListOfAllFoods();
    }
    public void payOrder(Order order){
        long financBalance=this.getFinancialBalance();
        long cost=order.getFood().getCost();
        if(financBalance>=cost){
            this.setFinancialBalance(financBalance-cost);
            this.previousOrders.add(order);
            this.cart.remove(order);
            order.getFood().getRestaurant().getPreviousOrder().add(order);
            order.getFood().getRestaurant().setFinancialBalance(order.getFood().getRestaurant().getFinancialBalance()+cost);
        }
    }

}
