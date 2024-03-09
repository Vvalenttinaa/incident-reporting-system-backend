package com.example.pisio.incidentreportingsystem.repositories;

import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.entitets.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsernameAndPassword(String username, String password) throws NotFoundException;
    Optional<UserEntity> findByUsername(String username) throws NotFoundException;
}
