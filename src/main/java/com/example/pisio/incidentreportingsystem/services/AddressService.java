package com.example.pisio.incidentreportingsystem.services;

import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.dto.Address;
import com.example.pisio.incidentreportingsystem.models.dto.Picture;

import java.util.List;

public interface AddressService {
    List<Address> findAll();
    Address findById(Integer id) throws NotFoundException;
    public Address insert(Address address) throws NotFoundException;

    public List<String> findAllPlaces() throws NotFoundException;
}
