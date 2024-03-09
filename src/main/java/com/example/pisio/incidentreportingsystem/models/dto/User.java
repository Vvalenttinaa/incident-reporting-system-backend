package com.example.pisio.incidentreportingsystem.models.dto;


import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer roleId;
    private String role;
}
