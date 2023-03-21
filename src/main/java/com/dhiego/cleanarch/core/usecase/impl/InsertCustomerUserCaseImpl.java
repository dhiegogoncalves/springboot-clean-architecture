package com.dhiego.cleanarch.core.usecase.impl;

import com.dhiego.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.dhiego.cleanarch.core.dataprovider.InsertCustomer;
import com.dhiego.cleanarch.core.domain.Customer;
import com.dhiego.cleanarch.core.usecase.InsertCustomerUserCase;

public class InsertCustomerUserCaseImpl implements InsertCustomerUserCase {

    private final FindAddressByZipCode findAddressByZipCode;
    private final InsertCustomer insertCustomer;

    public InsertCustomerUserCaseImpl(FindAddressByZipCode findAddressByZipCode, InsertCustomer insertCustomer) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.insertCustomer = insertCustomer;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);

        insertCustomer.insert(customer);
    }
}
