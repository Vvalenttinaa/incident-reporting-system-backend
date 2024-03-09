package com.example.pisio.incidentreportingsystem.repositories;

import com.example.pisio.incidentreportingsystem.models.entitets.IncidentEntity;
import com.example.pisio.incidentreportingsystem.models.entitets.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidentTypeEntityRepository extends JpaRepository<TypeEntity, Integer> {

}
