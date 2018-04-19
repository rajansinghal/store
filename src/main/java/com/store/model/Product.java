package com.store.model;

/**
 * Created by rsinghal on 4/19/2018.
 */
public class Product {

    private long id;
    private int price;
    private String description;
    private ProductCategory category;

    public Product() {
    }

    public Product(long id, int price, String description, ProductCategory category) {
        this.id = id;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}
