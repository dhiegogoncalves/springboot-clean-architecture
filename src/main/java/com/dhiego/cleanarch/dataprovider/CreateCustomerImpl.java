package com.dhiego.cleanarch.dataprovider;

import org.springframework.stereotype.Component;

import com.dhiego.cleanarch.core.dataprovider.CreateCustomer;
import com.dhiego.cleanarch.core.domain.Customer;
import com.dhiego.cleanarch.dataprovider.repository.CustomerRepository;
import com.dhiego.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CreateCustomerImpl implements CreateCustomer {

    private CustomerRepository customerRepository;
    private CustomerEntityMapper customerEntityMapper;

    public CreateCustomerImpl(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void create(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }

}
