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

                String name= reader.readLine();
                long cost=  Long.parseLong(reader.readLine());
                long restaurantId= Long.parseLong(reader.readLine());
                Restaurant restaurant= Restaurant.searchRestaurantById(restaurantId);
                Food food=new Food(name,cost,restaurant);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        filePath = "customercart.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            line = reader.readLine();
            int count=Integer.parseInt(line);
            for(int i=0;i<count;i++){

                long foodId= Long.parseLong(reader.readLine());
                long customerId= Long.parseLong(reader.readLine());
                long restaurantId= Long.parseLong(reader.readLine());
                Restaurant restaurant= Restaurant.searchRestaurantById(restaurantId);
                Customer customer= Customer.searchCustomertById(customerId);
                Food food=Food.searchFoodById(foodId);
                Order order=new Order(food,customer,restaurant);
                List<Order> custCart=customer.getCart();
                custCart.add(order);
                customer.setCart(custCart);

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

                long foodId= Long.parseLong(reader.readLine());
                long customerId= Long.parseLong(reader.readLine());
                long restaurantId= Long.parseLong(reader.readLine());
                Restaurant restaurant= Restaurant.searchRestaurantById(restaurantId);
                Customer customer= Customer.searchCustomertById(customerId);
                Food food=Food.searchFoodById(foodId);
                Order order=new Order(food,customer,restaurant);
                List<Order> custPreOrd=customer.getPreviousOrders();
                custPreOrd.add(order);
                customer.setPreviousOrders(custPreOrd);

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

                long foodId= Long.parseLong(reader.readLine());
                long customerId= Long.parseLong(reader.readLine());
                long restaurantId= Long.parseLong(reader.readLine());
                Restaurant restaurant= Restaurant.searchRestaurantById(restaurantId);
                Customer customer= Customer.searchCustomertById(customerId);
                Food food=Food.searchFoodById(foodId);
                Order order=new Order(food,customer,restaurant);
                List<Order> resPreOrd=restaurant.getPreviousOrder();
                resPreOrd.add(order);
                customer.setPreviousOrders(resPreOrd);

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
                writer.write(String.valueOf(Food.getListOfAllFoods().get(i).getRestaurant().getId()));
                writer.newLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        filePath="customercart.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            int count=0;
            for (int i=0;i<Customer.allCustomers.size();i++){
                count+=Customer.allCustomers.get(i).getCart().size();
            }
            writer.write(String.valueOf(count));
            writer.newLine();
            for (int i=0;i<Customer.allCustomers.size();i++){
                Customer customer=Customer.allCustomers.get(i);
                for(int j=0;j<customer.getCart().size();j++){
                    writer.write(String.valueOf(customer.getCart().get(j).getFood().getId()));
                    writer.newLine();
                    writer.write(String.valueOf(customer.getCart().get(j).getCustomer().getId()));
                    writer.newLine();
                    writer.write(String.valueOf(customer.getCart().get(j).getRestaurant().getId()));
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        filePath="customerpreviousorder.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            int count=0;
            for (int i=0;i<Customer.allCustomers.size();i++){
                count+=Customer.allCustomers.get(i).getCart().size();
            }
            writer.write(String.valueOf(count));
            writer.newLine();
            for (int i=0;i<Customer.allCustomers.size();i++){
                Customer customer=Customer.allCustomers.get(i);
                for(int j=0;j<customer.getCart().size();j++){
                    writer.write(String.valueOf(customer.getCart().get(j).getFood().getId()));
                    writer.newLine();
                    writer.write(String.valueOf(customer.getCart().get(j).getCustomer().getId()));
                    writer.newLine();
                    writer.write(String.valueOf(customer.getCart().get(j).getRestaurant().getId()));
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        filePath="restaurantpreviousorder.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            int count=0;
            for (int i=0;i<Customer.allCustomers.size();i++){
                count+=Customer.allCustomers.get(i).getCart().size();
            }
            writer.write(String.valueOf(count));
            writer.newLine();
            for (int i=0;i<Customer.allCustomers.size();i++){
                Customer customer=Customer.allCustomers.get(i);
                for(int j=0;j<customer.getCart().size();j++){
                    writer.write(String.valueOf(customer.getCart().get(j).getFood().getId()));
                    writer.newLine();
                    writer.write(String.valueOf(customer.getCart().get(j).getCustomer().getId()));
                    writer.newLine();
                    writer.write(String.valueOf(customer.getCart().get(j).getRestaurant().getId()));
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
