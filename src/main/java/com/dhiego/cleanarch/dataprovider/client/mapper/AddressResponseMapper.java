package com.dhiego.cleanarch.dataprovider.client.mapper;

import org.mapstruct.Mapper;

import com.dhiego.cleanarch.core.domain.Address;
import com.dhiego.cleanarch.dataprovider.client.response.AddressResponse;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
