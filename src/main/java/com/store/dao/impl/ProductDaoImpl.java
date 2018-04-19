package com.store.dao.impl;

import com.store.dao.CustomerDao;
import com.store.dao.ProductDao;
import com.store.model.Customer;
import com.store.model.CustomerType;
import com.store.model.Product;
import com.store.model.ProductCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsinghal on 4/19/2018.
 */
public class ProductDaoImpl implements ProductDao{

    @Override
    public Product findTypeById(long id){

        List<Product> productList = getInitializeProductRepo();
        for(Product product : productList){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }

    private List<Product> getInitializeProductRepo(){
        List<Product> products = new ArrayList<>();
        products.add( new Product(1,100,"desc", ProductCategory.GARMENT));
        products.add(new Product(2,200,"desc", ProductCategory.GARMENT));
        return products;
    }



}
