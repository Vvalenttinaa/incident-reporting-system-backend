package com.example.pisio.incidentreportingsystem.models.entitets;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "subtype", schema = "ncident_reporting_system", catalog = "")
public class SubtypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
   /* @Basic
    @Column(name = "type_id")
    private Integer typeId;

    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    private TypeEntity type;
    @OneToMany(mappedBy = "subtype")
    private List<IncidentEntity> incidentsById;

}
