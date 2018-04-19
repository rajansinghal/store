package com.store.service.impl;

import com.store.dao.CustomerDao;
import com.store.dao.impl.CustomerDaoImpl;
import com.store.model.CustomerType;
import com.store.model.Product;
import com.store.model.ProductCategory;
import com.store.service.DiscountService;

import java.util.List;

import static com.store.constant.Constant.DISCOUNT_ON_PRICE_BRACKET;
import static com.store.constant.Constant.PRICE_BRACKET_FOR_DISCOUNT;

/**
 * Created by rsinghal on 4/19/2018.
 */
public class DiscountServiceImpl implements DiscountService {

    CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public int calculateDiscountByUserType(long id) {
        CustomerType type = customerDao.findTypeById(id);
        //TODO make this configurable through propery file
        switch (type) {
            case BASIC:
                return 0;
            case PREMIUM:
                return 5;
            case AFFILIATE:
                return 10;
            case EMPLOYEE:
                return 30;
            default:
                return 0;
        }
    }

    @Override
    public int calculateDiscountOnProductList(long userId,List<Product> products) {
        if(products != null ){
            int discountPer = calculateDiscountByUserType(userId);
            int groceryBillAmount = 0;
            int nonGroceryBillAmount = 0;
            for(Product product  : products ){
                if(ProductCategory.GROCERY.toString().equalsIgnoreCase(product.getCategory().toString())){
                    groceryBillAmount = groceryBillAmount + product.getPrice();
                }else {
                    nonGroceryBillAmount = nonGroceryBillAmount + product.getPrice();
                }
            }
            int finalAmountAfterDiscount = nonGroceryBillAmount - ((nonGroceryBillAmount * discountPer)/100);
            return finalAmountAfterDiscount + groceryBillAmount;
        }
        return 0;
    }

    @Override
    public int calculateDiscountOnBillAmount(int billamount) {
        if(billamount > PRICE_BRACKET_FOR_DISCOUNT ){
            int bracketCountForDiscount = billamount / PRICE_BRACKET_FOR_DISCOUNT;
            int totalDiscount  = bracketCountForDiscount * DISCOUNT_ON_PRICE_BRACKET;
            return  billamount - totalDiscount;
        }
        return billamount;
    }
}
