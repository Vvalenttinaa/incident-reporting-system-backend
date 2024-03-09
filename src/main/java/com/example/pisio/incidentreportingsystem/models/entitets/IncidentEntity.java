package com.example.pisio.incidentreportingsystem.models.entitets;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "incident", schema = "ncident_reporting_system", catalog = "")
public class IncidentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "approved")
    private Boolean approved;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    private TypeEntity type;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subtype_id", referencedColumnName = "id", nullable = true)
    private SubtypeEntity subtype;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "picture_id", referencedColumnName = "id")
    private PictureEntity picture;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;

    @PrePersist
    private void onCreate(){
        createdAt = new Date();
    }
}
