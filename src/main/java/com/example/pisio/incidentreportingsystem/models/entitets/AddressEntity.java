package com.example.pisio.incidentreportingsystem.models.entitets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "address", schema = "ncident_reporting_system", catalog = "")
public class AddressEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "latitude")
    private Double latitude;
    @Basic
    @Column(name = "longitude")
    private Double longitude;
    @Basic
    @Column(name = "place")
    private String place;
    @OneToMany(mappedBy = "address")
    private List<IncidentEntity> incidentsById;

}
