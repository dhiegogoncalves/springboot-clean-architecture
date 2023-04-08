package com.dhiego.cleanarch.core.usecase;

import com.dhiego.cleanarch.core.domain.Customer;

public interface CreateCustomerUserCase {

    void create(Customer customer, String zipCode);
}
