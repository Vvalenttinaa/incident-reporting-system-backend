package com.example.pisio.incidentreportingsystem.controllers;

import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.dto.IncidentSubtype;
import com.example.pisio.incidentreportingsystem.models.dto.IncidentType;

import com.example.pisio.incidentreportingsystem.models.requests.IncidentTypeRequest;
import com.example.pisio.incidentreportingsystem.services.IncidentTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incidentTypes")
public class IncidentTypeController {

    private final IncidentTypeService incidentTypeService;

    public IncidentTypeController(IncidentTypeService incidentTypeService) {
        this.incidentTypeService = incidentTypeService;
    }

    @GetMapping
    public List<IncidentType> findAll()
    {
        return incidentTypeService.findAll();
    }
    @GetMapping("/{id}")
    public IncidentType findById(@PathVariable Integer id) throws NotFoundException {
        return incidentTypeService.findById(id);
    }
    @PostMapping
    public IncidentType insert(@RequestBody IncidentTypeRequest request) throws NotFoundException {
        return incidentTypeService.insert(request);
    }
}
