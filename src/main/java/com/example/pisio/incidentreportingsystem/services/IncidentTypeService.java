package com.example.pisio.incidentreportingsystem.services;

import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.dto.Incident;
import com.example.pisio.incidentreportingsystem.models.dto.IncidentSubtype;
import com.example.pisio.incidentreportingsystem.models.dto.IncidentType;
import com.example.pisio.incidentreportingsystem.models.requests.IncidentRequest;
import com.example.pisio.incidentreportingsystem.models.requests.IncidentTypeRequest;

import java.util.List;

public interface IncidentTypeService {
    List<IncidentType> findAll();
    IncidentType findById(Integer id) throws NotFoundException;
    IncidentType insert(IncidentTypeRequest request) throws NotFoundException;

}
