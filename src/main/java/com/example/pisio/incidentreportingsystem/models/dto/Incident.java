package com.example.pisio.incidentreportingsystem.models.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Incident {

    private Integer id;
    private String description;
    private Boolean approved;
    private Integer typeId;
    private String typeName;
    private Integer subtypeId;
    private String subtypeName;
    private Integer pictureId;
    private Timestamp createdAt;
    private  Integer addressId;
    private  String addressName;
    private Double addressLatitude;
    private Double addressLongitude;
    private  String addressPlace;
}
