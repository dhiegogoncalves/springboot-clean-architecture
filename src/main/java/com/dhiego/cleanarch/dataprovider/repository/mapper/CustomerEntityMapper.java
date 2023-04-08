package com.dhiego.cleanarch.dataprovider.repository.mapper;

import org.mapstruct.Mapper;

import com.dhiego.cleanarch.core.domain.Customer;
import com.dhiego.cleanarch.dataprovider.repository.entity.CustomerEntity;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);
}
