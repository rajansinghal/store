package com.store.model;

import java.util.List;

/**
 * Created by rsinghal on 4/19/2018.
 */
public class Customer {

    private long id;
    private String name;
    private String address;
    private CustomerType category;
    private List<Product> productList;

    public Customer() {
    }

    public Customer(long id, String name, String address, CustomerType category, List<Product> productList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.category = category;
        this.productList = productList;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCategory() {
        return category;
    }

    public void setCategory(CustomerType category) {
        this.category = category;
    }

    public Customer(List<Product> productList) {
        this.productList = productList;
    }
}
