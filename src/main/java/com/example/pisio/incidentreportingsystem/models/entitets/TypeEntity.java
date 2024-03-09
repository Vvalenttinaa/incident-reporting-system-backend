package com.example.pisio.incidentreportingsystem.models.entitets;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "type", schema = "ncident_reporting_system", catalog = "")
public class TypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "type")
    private List<IncidentEntity> incidentsById;
    @OneToMany(mappedBy = "type")
    private List<SubtypeEntity> subtypesById;

}
