package com.example.pisio.incidentreportingsystem.services;

import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.dto.Picture;
import com.example.pisio.incidentreportingsystem.models.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    List<User> findAll();
    User findById(Integer id) throws NotFoundException;
    User findByUsernameAndPassword(String username, String password) throws NotFoundException;
    User findByUsername(String username) throws  NotFoundException;
}
