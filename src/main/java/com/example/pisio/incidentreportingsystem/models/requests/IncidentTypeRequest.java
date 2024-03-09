package com.example.pisio.incidentreportingsystem.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IncidentTypeRequest {
    @NotNull
    private Integer id;
    @NotBlank
    private String name;
}
