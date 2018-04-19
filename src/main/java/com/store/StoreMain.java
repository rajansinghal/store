package com.store;

import com.store.model.Customer;
import com.store.model.CustomerType;
import com.store.model.Product;
import com.store.model.ProductCategory;
import com.store.service.DiscountService;
import com.store.service.impl.DiscountServiceImpl;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

/**
 * Created by rsinghal on 4/19/2018.
 */
public class StoreMain {

    public  static void  main(String arr[]){

        Product product1 = new Product(1,100,"desc", ProductCategory.GARMENT);
        Product product2 = new Product(2,95,"desc", ProductCategory.GROCERY);
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);


        Customer customer = new Customer(1,"customer 1", "address 1", CustomerType.BASIC,products);
        DiscountService discountService = new DiscountServiceImpl();
        int billableAmount = discountService.calculateDiscountOnProductList(customer.getId(),products);
        int finalBillAmount = discountService.calculateDiscountOnBillAmount(billableAmount);
        System.out.println(finalBillAmount);



        Customer customerNew = new Customer(5,"customer 5", "address 5", CustomerType.BASIC,products);
        DiscountService discountService1 = new DiscountServiceImpl();
        int billableAmountNew = discountService1.calculateDiscountOnProductList(customer.getId(),products);
        int finalBillAmountNew = discountService1.calculateDiscountOnBillAmount(billableAmountNew);
        System.out.println(finalBillAmountNew);

    }

}
