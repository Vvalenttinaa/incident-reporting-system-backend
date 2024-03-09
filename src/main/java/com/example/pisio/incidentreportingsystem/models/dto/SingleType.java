package com.example.pisio.incidentreportingsystem.models.dto;

import com.example.pisio.incidentreportingsystem.models.entitets.SubtypeEntity;
import lombok.Data;

import java.util.List;

@Data
public class SingleType extends IncidentType {
    List<Incident> incidents;
    List<IncidentSubtype> subtypes;
}
