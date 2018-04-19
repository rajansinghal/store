package com.store.dao.impl;

import com.store.dao.CustomerDao;
import com.store.model.Customer;
import com.store.model.CustomerType;
import com.store.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsinghal on 4/19/2018.
 */
public class CustomerDaoImpl implements CustomerDao{

    @Override
    public  CustomerType findTypeById(long id){

        List<Customer> customerList = getInitializeCustomerRepo();
        for(Customer customer : customerList){
            if(customer.getId() == id){
                return customer.getCategory();
            }
        }
        return CustomerType.BASIC;
    }

    private List<Customer> getInitializeCustomerRepo(){
        List<Customer> customers = new ArrayList<>();
        customers.add( new Customer(1,"customer 1", "address 1", CustomerType.AFFILIATE,null));
        customers.add(new Customer(2,"customer 2", "address 2", CustomerType.BASIC,null));
        customers.add(new Customer(3,"customer 3", "address 3", CustomerType.PREMIUM,null));
        customers.add(new Customer(4,"customer 4", "address 4", CustomerType.EMPLOYEE,null));
        return customers;
    }



}
