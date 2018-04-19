package com.store.service;

import com.store.model.Product;

import java.util.List;

/**
 * Created by rsinghal on 4/19/2018.
 */
public interface DiscountService {
    int calculateDiscountByUserType(long id);
    int calculateDiscountOnProductList(long id,List<Product> products);
    int calculateDiscountOnBillAmount(int billamount);

}
