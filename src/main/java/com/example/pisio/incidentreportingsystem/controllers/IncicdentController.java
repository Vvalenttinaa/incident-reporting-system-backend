package com.example.pisio.incidentreportingsystem.controllers;

import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.dto.Incident;
import com.example.pisio.incidentreportingsystem.models.requests.IncidentRequest;
import com.example.pisio.incidentreportingsystem.services.IncidentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/incidents")
public class IncicdentController {

    private final IncidentService incidentService;

    public IncicdentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @GetMapping
    public List<Incident> findAll()
    {
        return incidentService.findAll();
    }
    @GetMapping("/{id}")
    public Incident findById(@PathVariable Integer id) throws NotFoundException {
        return incidentService.findById(id);
    }
    @GetMapping("/approved")
    public List<Incident> findAllApproved() throws NotFoundException {
        return incidentService.findAllApproved(true);
    }
    @GetMapping("/notApproved")
    public List<Incident> findAllNotApproved() throws NotFoundException {
        return incidentService.findAllNotApproved(null);
    }
    @GetMapping("/rejected")
    public List<Incident> findAllRejected() throws NotFoundException {
        return incidentService.findAllRejected(false);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Incident insert(@RequestBody IncidentRequest request) throws NotFoundException, IOException {
        return incidentService.insert(request);
    }

    @DeleteMapping("{id}/deleteIncident")
    public void deleteIncident(@PathVariable Integer id) throws NotFoundException {
        incidentService.deleteIncident(id);
    }

    @PutMapping("{id}/approveIncident")
    public void approveIncident(@PathVariable Integer id) throws NotFoundException{
        incidentService.approveIncident(id);
    }

    @PutMapping("{id}/rejectIncident")
    public void rejectIncident(@PathVariable Integer id) throws NotFoundException{
        incidentService.rejectIncident(id);
    }
}
