package com.example.pisio.incidentreportingsystem.repositories;

import com.example.pisio.incidentreportingsystem.models.entitets.IncidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IncidentEntityRepository extends JpaRepository<IncidentEntity, Integer> {
    List<IncidentEntity> findAllByApproved(Boolean approved);
}
