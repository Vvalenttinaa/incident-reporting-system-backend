package com.example.pisio.incidentreportingsystem.models.entitets;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.util.List;

@Data
@Entity
@Table(name = "picture")
public class PictureEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Column(name="type")
    private String type;
    @Basic
    @Column(name = "cover")
    private byte[] imageData;
    @OneToMany(mappedBy = "picture")
    private List<IncidentEntity> incidents;

}
