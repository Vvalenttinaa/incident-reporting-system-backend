package com.example.pisio.incidentreportingsystem.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class SingleSubtype extends IncidentSubtype{
    List<Incident> incidents;
}
