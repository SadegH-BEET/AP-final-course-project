package model;

import java.util.ArrayList;
import java.util.List;

public class Food {
    public static List<Food> listOfAllFoods =new ArrayList<>();
    public static long idcounter=0;


    private long id;
    private String name;
    private long cost;
    private Restaurant restaurant;

    public Food(String name, long cost, Restaurant restaurant) {
        this.id=idcounter;
        idcounter++;
        this.name = name;
        this.cost = cost;
        this.restaurant=restaurant;
        listOfAllFoods.add(this);

    }

    public static List<Food> getListOfAllFoods() {
        return listOfAllFoods;
    }

    public static void setListOfAllFoods(List<Food> listOfAllFoods) {
        Food.listOfAllFoods = listOfAllFoods;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getCost() {
        return cost;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public static Food findFoodByName(String name){
        for(int i=0;i<Food.listOfAllFoods.size();i++){
            if(name.equals(Food.listOfAllFoods.get(i).getName())){
                return Food.listOfAllFoods.get(i);
            }
        }
        return null;
    }


    public static Food searchFoodByName(String foodName) {
        int index=0;
        for(int i=0;i<listOfAllFoods.size();i++){
            if (listOfAllFoods.get(i).getName().equals(foodName)){
                index=i;
                break;
            }
        }
        return listOfAllFoods.get(index);
    }

    public static Food searchFoodById(long foodId) {
        int index = 0;
        for (int i = 0; i < listOfAllFoods.size(); i++) {
            if (listOfAllFoods.get(i).id==foodId ){
                index = i;
                break;
            }
        }
        return listOfAllFoods.get(index);
    }

}
