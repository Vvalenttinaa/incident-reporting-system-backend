package com.example.pisio.incidentreportingsystem.controllers;

import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.dto.Address;
import com.example.pisio.incidentreportingsystem.models.dto.Picture;
import com.example.pisio.incidentreportingsystem.repositories.AddressEntityRepository;
import com.example.pisio.incidentreportingsystem.repositories.PictureEntityRepository;
import com.example.pisio.incidentreportingsystem.services.AddressService;
import com.example.pisio.incidentreportingsystem.services.PictureService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@Data
public class AddressController {
    @Autowired
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> findAll()
    {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable Integer id) throws NotFoundException {
        return addressService.findById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Address insert(@RequestBody Address request) throws NotFoundException {
        return addressService.insert(request);
    }
}
