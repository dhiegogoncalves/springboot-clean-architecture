package com.dhiego.cleanarch.core.usecase;

import com.dhiego.cleanarch.core.domain.Customer;

public interface InsertCustomerUserCase {

    void insert(Customer customer, String zipCode);
}
