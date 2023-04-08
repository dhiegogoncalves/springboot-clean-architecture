package com.dhiego.cleanarch.dataprovider;

import org.springframework.stereotype.Component;

import com.dhiego.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.dhiego.cleanarch.core.domain.Address;
import com.dhiego.cleanarch.dataprovider.client.FindAddressByZipCodeClient;
import com.dhiego.cleanarch.dataprovider.client.mapper.AddressResponseMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class FindAddressByZipCodeImpl implements FindAddressByZipCode {

    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    private AddressResponseMapper addressResponseMapper;

    public FindAddressByZipCodeImpl(FindAddressByZipCodeClient findAddressByZipCodeClient,
            AddressResponseMapper addressResponseMapper) {
        this.findAddressByZipCodeClient = findAddressByZipCodeClient;
        this.addressResponseMapper = addressResponseMapper;
    }

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
