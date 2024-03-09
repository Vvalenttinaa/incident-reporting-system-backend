package com.example.pisio.incidentreportingsystem.models.dto;

import com.example.pisio.incidentreportingsystem.models.entitets.IncidentEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class Picture {
    private Integer id;
    private String name;
    private String type;
    private byte[] imageData;
}
