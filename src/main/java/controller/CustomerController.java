package controller;

import model.Customer;

public class CustomerController {

    public static boolean isCustomerValid(String name,String password){
        boolean found=false;
        Customer customer=Customer.searchRestaurantByName(name);
        if(customer==null)
            found=false;
        else {
            if(customer.getPassword().equals(password))
                found=true;
            else
                found=false;
        }
        return found;
    }

    public static Customer searchRestaurantByName(String customerName) {
        int index = 0;
        for (int i = 0; i < Customer.allCustomers.size(); i++) {
            if ((Customer.allCustomers.get(i).getName()).equals(customerName)) {
                index = i;
                break;
            }
        }
        return Customer.allCustomers.get(index);
    }

}

