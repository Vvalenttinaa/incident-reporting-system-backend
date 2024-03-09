package com.example.pisio.incidentreportingsystem.services.impl;

import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.dto.Address;
import com.example.pisio.incidentreportingsystem.models.dto.SingleAddress;
import com.example.pisio.incidentreportingsystem.models.entitets.AddressEntity;
import com.example.pisio.incidentreportingsystem.repositories.AddressEntityRepository;
import com.example.pisio.incidentreportingsystem.services.AddressService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private final ModelMapper modelMapper;
    private final AddressEntityRepository addressEntityRepository;

    @PersistenceContext
    private EntityManager manager;

    public AddressServiceImpl(AddressEntityRepository addressEntityRepository, ModelMapper modelMapper) {
        this.addressEntityRepository = addressEntityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Address> findAll() {
        return addressEntityRepository.findAll().stream().map(l->modelMapper.map(l, Address.class)).collect(Collectors.toList());
    }

    @Override
    public SingleAddress findById(Integer id) throws NotFoundException {
        return modelMapper.map(addressEntityRepository.findById(id).orElseThrow(NotFoundException::new), SingleAddress.class);
    }

    @Override
    public Address insert(Address address) throws NotFoundException
    {
        AddressEntity entity=modelMapper.map(address, AddressEntity.class);
        Optional<AddressEntity> addressEntity= addressEntityRepository.findIdByNameAndLatAndLng(address.getName(), address.getLatitude(), address.getLongitude());
        if(!addressEntity.isPresent()) {
            entity.setId(null);
            String[] parts =  address.getName().split(",");
            String pom = parts[1].trim();
            pom = pom.replaceAll("\\d", "");
            entity.setPlace(pom);
            entity = addressEntityRepository.saveAndFlush(entity);
        }
        //     manager.refresh(entity);
        return findById(entity.getId());
    }

    @Override
    public List<String> findAllPlaces() throws NotFoundException {
        List<Address> addresses = findAll();
        Set<String> places = new HashSet<>();
        for (Address a: addresses
             ) {
           String[] parts =  a.getName().split(",");
           String pom = parts[1].trim();
           pom.replaceAll("\\d", "");
           places.add(pom);
        }
        List<String>returning = new ArrayList<>();
        for (String s:places
             ) {
            returning.add(s);
        }
        return returning;
    }
}
