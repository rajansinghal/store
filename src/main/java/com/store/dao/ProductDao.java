package com.store.dao;

import com.store.model.CustomerType;
import com.store.model.Product;

/**
 * Created by rsinghal on 4/19/2018.
 */
public interface ProductDao {
    Product findTypeById(long id);
}
