package com.example.pisio.incidentreportingsystem.services;

import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.dto.IncidentSubtype;

import java.util.List;
import java.util.Optional;

public interface IncidentSubtypeService {
    List<IncidentSubtype> findAll();
    IncidentSubtype findById(Integer id) throws NotFoundException;
    IncidentSubtype insert(IncidentSubtype incidentSubtype) throws NotFoundException;
    List<IncidentSubtype>findAllSubtypesByTypeId(Integer id) throws NotFoundException;

}
