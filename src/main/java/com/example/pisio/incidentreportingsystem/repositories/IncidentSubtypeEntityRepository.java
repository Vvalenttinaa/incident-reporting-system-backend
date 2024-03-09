package com.example.pisio.incidentreportingsystem.repositories;

import com.example.pisio.incidentreportingsystem.models.entitets.SubtypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidentSubtypeEntityRepository extends JpaRepository<SubtypeEntity, Integer> {
    List<SubtypeEntity> findAllByTypeId(Integer id);
}
