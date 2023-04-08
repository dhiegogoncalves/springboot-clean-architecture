package com.dhiego.cleanarch.entrypoint.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dhiego.cleanarch.core.usecase.CreateCustomerUserCase;
import com.dhiego.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import com.dhiego.cleanarch.entrypoint.controller.request.CustomerRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private CreateCustomerUserCase createCustomerUserCase;
    private CustomerMapper customerMapper;

    public CustomerController(CreateCustomerUserCase createCustomerUserCase, CustomerMapper customerMapper) {
        this.createCustomerUserCase = createCustomerUserCase;
        this.customerMapper = customerMapper;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public void create(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        this.createCustomerUserCase.create(customer, customerRequest.getZipCode());
    }
}
