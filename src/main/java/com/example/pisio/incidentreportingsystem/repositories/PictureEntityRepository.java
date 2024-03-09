package com.example.pisio.incidentreportingsystem.repositories;

import com.example.pisio.incidentreportingsystem.models.dto.Picture;
import com.example.pisio.incidentreportingsystem.models.entitets.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface PictureEntityRepository extends JpaRepository<PictureEntity, Integer> {
    Optional<PictureEntity> findByName(String name);
}