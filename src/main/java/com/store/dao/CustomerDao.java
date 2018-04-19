package com.store.dao;

import com.store.model.CustomerType;

/**
 * Created by rsinghal on 4/19/2018.
 */
public interface CustomerDao {
    CustomerType findTypeById(long id);
}
