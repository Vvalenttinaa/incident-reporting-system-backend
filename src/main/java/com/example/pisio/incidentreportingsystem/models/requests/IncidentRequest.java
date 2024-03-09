package com.example.pisio.incidentreportingsystem.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IncidentRequest {
    @NotNull
    private Integer id;
    @NotBlank
    private String description;
    private Boolean approved;
    @NotNull
    private Integer type;
    private Integer subtype;
    @NotBlank
    private String addressName;
    @NotBlank
    private Double longitude;
    @NotBlank
    private Double latitude;
    private Integer imageId;
}
