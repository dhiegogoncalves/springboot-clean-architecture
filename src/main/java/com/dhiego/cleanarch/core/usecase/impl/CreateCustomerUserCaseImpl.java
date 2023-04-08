package com.dhiego.cleanarch.core.usecase.impl;

import com.dhiego.cleanarch.core.dataprovider.CreateCustomer;
import com.dhiego.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.dhiego.cleanarch.core.domain.Customer;
import com.dhiego.cleanarch.core.usecase.CreateCustomerUserCase;

public class CreateCustomerUserCaseImpl implements CreateCustomerUserCase {

    private final FindAddressByZipCode findAddressByZipCode;
    private final CreateCustomer createCustomer;

    public CreateCustomerUserCaseImpl(FindAddressByZipCode findAddressByZipCode, CreateCustomer createCustomer) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.createCustomer = createCustomer;
    }

    @Override
    public void create(Customer customer, String zipCode) {
        var address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);

        createCustomer.create(customer);
    }
}
