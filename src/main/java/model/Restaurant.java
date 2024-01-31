package model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public static List<Restaurant> allRestaurants=new ArrayList<>();
    public static long idcounter=0;
    public static Restaurant currentRestaurant=null;

    public static List<Restaurant> getListOfRestaurants(){
        return allRestaurants;
    }
    private long id;
    private String name;
    private String manager;
    private String password;
    private String address;
    private long financialBalance=0;
    private List<Food> foodMennu =new ArrayList<>();
    private List<Order> previousOrder=new ArrayList<>();

    public Restaurant(String name, String manager, String address, String password) {
        this.id=idcounter;
        idcounter++;
        this.name = name;
        this.manager = manager;
        this.address = address;
        this.password = password;
        allRestaurants.add(this);

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static Restaurant searchRestaurantByName(String name) {
        int index = 0;
        for (int i = 0; i < allRestaurants.size(); i++) {
            if ((allRestaurants.get(i).name).equals(name)) {
                index = i;
                break;
            }
        }
        return allRestaurants.get(index);
    }

    public String getPassword() {
        return password;
    }

    public static void setAllRestaurants(List<Restaurant> allRestaurants) {
        Restaurant.allRestaurants = allRestaurants;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getNumberOfAllRestaurants() {
        return Restaurant.allRestaurants.size();
    }

    public String getName() {
        return name;
    }

    public String getManager() {
        return manager;
    }

    public String getAddress() {
        return address;
    }

    public long getFinancialBalance() {
        return financialBalance;
    }

    public List<Food> getFoodMennu() {
        return foodMennu;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFinancialBalance(long financialBalance) {
        this.financialBalance = financialBalance;
    }

    public void setFoodMennu(List<Food> foodMennu) {
        this.foodMennu = foodMennu;
    }

    public void setPreviousOrder(List<Order> previousOrder) {
        this.previousOrder = previousOrder;
    }

    public List<Order> getPreviousOrder() {
        return previousOrder;
    }

    public void changeAddress(String newAddress)
    {
        this.setAddress(newAddress);
    }

    public void removeFromFoodMenu(Food food){
        List<Food> foodmenu=this.getFoodMennu();
        foodmenu.remove(food);
        this.setFoodMennu(foodmenu);
    }
    public void addToFoodMenu(Food food){
        List<Food> foodmenu=this.getFoodMennu();
        foodmenu.add(food);
        this.setFoodMennu(foodmenu);
    }
    public void increasFinancialBalance(long increaseValue){
        this.financialBalance=this.getFinancialBalance()+increaseValue;
    }
    public List<Food> ShowRestaurantMenu(){
        return this.foodMennu;
    }
    public void withdrawFinancialBalnce(String numcart,long value){
        this.setFinancialBalance(this.getFinancialBalance()-value);
    }
    public void printFoodMenu(){
        System.out.println("==============================");
        System.out.println(this.name +" restaurant food menu");
        for(int i=0;i<this.foodMennu.size();i++){

            System.out.println(i+
                    " food name: "+foodMennu.get(i).getName()+
                    " cost: "+foodMennu.get(i).getCost());
        }
        System.out.println("==============================");
    }


    public void printPreviousOrder() {
        System.out.println("==============================");
        System.out.println(this.name +" restaurant previous orders");
        for(int i=0;i<this.previousOrder.size();i++){
            System.out.println(i+
                    " food name " + previousOrder.get(i).getFood().getName());
        }
        System.out.println("==============================");


    }

    public Food searchFoodMenu(String foodName) {
        int index=0;
        boolean found=false;
        for (int i=0;i<this.getFoodMennu().size();i++){
            if(this.getFoodMennu().get(i).equals(foodName)){
                index=i;
                found=true;
                break;
            }
        }
        return this.foodMennu.get(index);

    }

    public static Restaurant searchRestaurantById(long restaurantId) {
        int index = 0;
        for (int i = 0; i < allRestaurants.size(); i++) {
            if (Restaurant.allRestaurants.get(i).id==restaurantId ){
                index = i;
                break;
            }
        }
        return Restaurant.allRestaurants.get(index);

    }

    public void addPreviousOrder(Order order){
        List<Order> previousOrder= this.getPreviousOrder();
        previousOrder.add(order);
        this.setPreviousOrder(previousOrder);
    }


}
