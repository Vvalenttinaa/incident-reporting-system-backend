package com.example.pisio.incidentreportingsystem.controllers;

import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.dto.IncidentSubtype;
import com.example.pisio.incidentreportingsystem.services.IncidentSubtypeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incidentSubtypes")
public class IncidentSubtypeController {

    private final IncidentSubtypeService incidentSubtypeService;

    public IncidentSubtypeController(IncidentSubtypeService incidentSubtypeService) {
        this.incidentSubtypeService = incidentSubtypeService;
    }

    @GetMapping
    public List<IncidentSubtype> findAll()
    {
        return incidentSubtypeService.findAll();
    }

    @GetMapping("/{id}")
    public IncidentSubtype findById(@PathVariable Integer id) throws NotFoundException {
        return incidentSubtypeService.findById(id);
    }
    @GetMapping("/types/{id}")
    public List<IncidentSubtype> findByTypeId(@PathVariable Integer id) throws NotFoundException{
        return incidentSubtypeService.findAllSubtypesByTypeId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IncidentSubtype insert(@RequestBody IncidentSubtype request) throws NotFoundException {
        return incidentSubtypeService.insert(request);
    }
}
