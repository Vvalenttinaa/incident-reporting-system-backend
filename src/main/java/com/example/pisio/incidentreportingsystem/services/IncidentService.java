package com.example.pisio.incidentreportingsystem.services;

import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.dto.Incident;
import com.example.pisio.incidentreportingsystem.models.dto.Picture;
import com.example.pisio.incidentreportingsystem.models.requests.IncidentRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IncidentService {
    List<Incident> findAll();
    Incident findById(Integer id) throws NotFoundException;
    List<Incident> findAllApproved(Boolean approved) throws NotFoundException;

    List<Incident> findAllNotApproved(Boolean approved) throws NotFoundException;

    List<Incident> findAllRejected(Boolean approved) throws NotFoundException;

    Incident insert(IncidentRequest request) throws NotFoundException, IOException;
    void approveIncident(Integer id);

    void rejectIncident(Integer id);

    void  deleteIncident(Integer id);
}

