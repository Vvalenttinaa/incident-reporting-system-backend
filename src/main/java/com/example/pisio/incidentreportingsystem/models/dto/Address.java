package com.example.pisio.incidentreportingsystem.models.dto;

import com.example.pisio.incidentreportingsystem.models.entitets.IncidentEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class Address {
    private Integer id;
    private String name;
    private Double latitude;
    private Double longitude;
    private String place;
}
