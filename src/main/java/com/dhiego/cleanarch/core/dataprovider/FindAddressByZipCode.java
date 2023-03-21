package com.dhiego.cleanarch.core.dataprovider;

import com.dhiego.cleanarch.core.domain.Address;

public interface FindAddressByZipCode {

    Address find(final String zipCode);
}
