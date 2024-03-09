package com.example.pisio.incidentreportingsystem.repositories;

import com.example.pisio.incidentreportingsystem.models.entitets.AddressEntity;
import lombok.Data;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface AddressEntityRepository extends JpaRepository<AddressEntity, Integer> {
    @Query("SELECT a FROM AddressEntity a WHERE a.name = :name AND a.latitude = :lat AND a.longitude = :lng")
    Optional<AddressEntity> findIdByNameAndLatAndLng(String name, Double lat, Double lng);

}
