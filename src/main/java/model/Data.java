package model;

import java.io.*;
import java.util.List;

public class Data {


    public static void loadData(){
        String filePath = "customer.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            line = reader.readLine();
            int count=Integer.parseInt(line);
            for(int i=0;i<count;i++){
                String name= reader.readLine();
                String password= reader.readLine();
                String address= reader.readLine();
                long financialbalance= Long.parseLong(reader.readLine());
                Customer customer=new Customer(name,password,address);
                customer.setFinancialBalance(financialbalance);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        filePath = "restaurant.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            line = reader.readLine();
            int count=Integer.parseInt(line);
            for(int i=0;i<count;i++){

                String name= reader.readLine();
                String manager= reader.readLine();
                String address= reader.readLine();
                String password= reader.readLine();
                long financialbalance=  Long.parseLong(reader.readLine());
                Restaurant restaurant=new Restaurant(name,manager,address,password);
                restaurant.setFinancialBalance(financialbalance);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        filePath = "food.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            line = reader.readLine();
            int count=Integer.parseInt(line);
            for(int i=0;i<count;i++){

                String name = reader.readLine();
                long cost =  Long.parseLong(reader.readLine());
                String restaurantName= reader.readLine();
                Restaurant restaurant= Restaurant.searchRestaurantByName(restaurantName);
                Food food=new Food(name,cost,restaurant);
                restaurant.addToFoodMenu(food);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        filePath = "customerpreviousorder.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            line = reader.readLine();
            int count=Integer.parseInt(line);
            for(int i=0;i<count;i++){

                String foodName= reader.readLine();
                String customerName= reader.readLine();
                String restaurantName= reader.readLine();
                Restaurant restaurant= Restaurant.searchRestaurantByName(restaurantName);
                Customer customer= Customer.searchCustomerByName(customerName);
                if(restaurant.searchFoodMenu(foodName)!=null){
                    Food food=restaurant.searchFoodMenu(foodName);
                    Order order=new Order(food,customer,restaurant);
                    List<Order> custPre=customer.getPreviousOrders();
                    custPre.add(order);
                    customer.setCart(custPre);}

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        filePath = "restaurantpreviousorder.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            line = reader.readLine();
            int count=Integer.parseInt(line);
            for(int i=0;i<count;i++){

                String foodName= reader.readLine();
                String customerName= reader.readLine();
                String restaurantName= reader.readLine();
                Restaurant restaurant= Restaurant.searchRestaurantByName(restaurantName);
                Customer customer= Customer.searchCustomerByName(customerName);
                if(restaurant.searchFoodMenu(foodName)!=null){
                    Food food=restaurant.searchFoodMenu(foodName);
                    Order order=new Order(food,customer,restaurant);
                    List<Order> resPre=restaurant.getPreviousOrder();
                    resPre.add(order);
                    customer.setCart(resPre);}

            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    public static void downLoadData(){
        String filePath="customer.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.valueOf(Customer.allCustomers.size()));
            writer.newLine();
            for (int i=0;i<Customer.allCustomers.size();i++){
                writer.write(Customer.allCustomers.get(i).getName());
                writer.newLine();
                writer.write(Customer.allCustomers.get(i).getPassword());
                writer.newLine();
                writer.write(Customer.allCustomers.get(i).getAddress());
                writer.newLine();
                writer.write(String.valueOf(Customer.allCustomers.get(i).getFinancialBalance()));
                writer.newLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        filePath="restaurant.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.valueOf(Restaurant.getListOfRestaurants().size()));
            writer.newLine();
            for (int i=0;i<Restaurant.getListOfRestaurants().size();i++){
                writer.write(Restaurant.getListOfRestaurants().get(i).getName());
                writer.newLine();
                writer.write(Restaurant.getListOfRestaurants().get(i).getManager());
                writer.newLine();
                writer.write(Restaurant.getListOfRestaurants().get(i).getAddress());
                writer.newLine();
                writer.write(Restaurant.getListOfRestaurants().get(i).getPassword());
                writer.newLine();
                writer.write(String.valueOf(Restaurant.getListOfRestaurants().get(i).getFinancialBalance()));
                writer.newLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        filePath="Food.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.valueOf(Food.getListOfAllFoods().size()));
            writer.newLine();
            for (int i=0;i<Food.getListOfAllFoods().size();i++){
                writer.write(Food.getListOfAllFoods().get(i).getName());
                writer.newLine();
                writer.write(String.valueOf(Food.getListOfAllFoods().get(i).getCost()));
                writer.newLine();
                writer.write(Food.getListOfAllFoods().get(i).getRestaurant().getName());
                writer.newLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        filePath="customerpreviousorder.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            int count=0;
            for (int i=0;i<Customer.allCustomers.size();i++){
                count+=Customer.allCustomers.get(i).getPreviousOrders().size();
            }
            writer.write(String.valueOf(count));
            writer.newLine();
            for (int i=0;i<Customer.allCustomers.size();i++){
                Customer customer=Customer.allCustomers.get(i);
                for(int j=0;j<customer.getPreviousOrders().size();j++){
                    writer.write(customer.getPreviousOrders().get(j).getFood().getName());
                    writer.newLine();
                    writer.write(customer.getPreviousOrders().get(j).getCustomer().getName());
                    writer.newLine();
                    writer.write(customer.getPreviousOrders().get(j).getRestaurant().getName());
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        filePath="restaurantpreviousorder.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            int count=0;
            for (int i=0;i<Restaurant.allRestaurants.size();i++){
                count+=Restaurant.allRestaurants.get(i).getPreviousOrder().size();
            }
            writer.write(String.valueOf(count));
            writer.newLine();
            for (int i=0;i<Restaurant.allRestaurants.size();i++){
                Restaurant restaurant=Restaurant.allRestaurants.get(i);
                for(int j=0;j<restaurant.getPreviousOrder().size();j++){
                    writer.write(restaurant.getPreviousOrder().get(j).getFood().getName());
                    writer.newLine();
                    writer.write(restaurant.getPreviousOrder().get(j).getCustomer().getName());
                    writer.newLine();
                    writer.write(restaurant.getPreviousOrder().get(j).getRestaurant().getName());
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
