package com.store.service.impl;

import com.store.dao.CustomerDao;
import com.store.dao.impl.CustomerDaoImpl;
import com.store.model.Customer;
import com.store.model.CustomerType;
import com.store.model.Product;
import com.store.model.ProductCategory;
import com.store.service.DiscountService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rsinghal on 4/19/2018.
 */
public class DiscountServiceImplTest {

    DiscountService discountService;
    List<Product> products;

    @Before
    public void setUp() throws Exception {
        discountService = new DiscountServiceImpl();
        Product product1 = new Product(1, 100, "desc", ProductCategory.GARMENT);
        Product product2 = new Product(2, 95, "desc", ProductCategory.GROCERY);
        products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
    }

    @Test
    public void calculate_discount_when_user_is_basic() throws Exception {
        int discountToBeApplied = discountService.calculateDiscountByUserType(2);
        assertEquals(0, discountToBeApplied);
    }

    @Test
    public void calculate_discount_when_user_is_preminum() throws Exception {
        int discountToBeApplied = discountService.calculateDiscountByUserType(3);
        assertEquals(5, discountToBeApplied);
    }

    @Test
    public void calculate_discount_when_user_is_affiliated() throws Exception {
        int discountToBeApplied = discountService.calculateDiscountByUserType(1);
        assertEquals(10, discountToBeApplied);
    }

    @Test
    public void calculate_discount_when_user_is_employee() throws Exception {
        int discountToBeApplied = discountService.calculateDiscountByUserType(4);
        assertEquals(30, discountToBeApplied);
    }

    @Test
    public void calculate_discount_when_customer_is_new() throws Exception {
        Customer customerNew = new Customer(5, "customer 1", "address 1", CustomerType.BASIC, products);
        int billamount = discountService.calculateDiscountOnProductList(customerNew.getId(), products);
        assertEquals(195, billamount);
    }

    @Test
    public void calculate_discount_when_customer_is_existing_and_affiliated() throws Exception {
        int billamount = discountService.calculateDiscountOnProductList(1, products);
        assertEquals(185, billamount);
    }

    @Test
    public void calculate_discount_when_customer_is_existing_and_basic() throws Exception {
        int billamount = discountService.calculateDiscountOnProductList(2, products);
        assertEquals(195, billamount);
    }

    @Test
    public void calculate_discount_when_customer_is_existing_and_employee() throws Exception {
        int billamount = discountService.calculateDiscountOnProductList(4, products);
        assertEquals(165, billamount);
    }

    @Test
    public void calculate_discount_when_customer_is_existing_and_premium() throws Exception {
        int billamount = discountService.calculateDiscountOnProductList(3, products);
        assertEquals(190, billamount);
    }

    @Test
    public void calculate_discount_on_bill_amount() throws Exception {

        assertEquals(855, discountService.calculateDiscountOnBillAmount(900));
        assertEquals(0, discountService.calculateDiscountOnBillAmount(0));
        assertEquals(100, discountService.calculateDiscountOnBillAmount(105));

    }

}