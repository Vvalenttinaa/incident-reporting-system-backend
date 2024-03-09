package com.example.pisio.incidentreportingsystem.models.entitets;

import jakarta.persistence.*;

@Entity
@Table(name = "role", schema = "ncident_reporting_system", catalog = "")
public class RoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;

}
