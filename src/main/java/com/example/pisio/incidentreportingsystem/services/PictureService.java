package com.example.pisio.incidentreportingsystem.services;

import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.dto.Picture;
import com.example.pisio.incidentreportingsystem.models.entitets.PictureEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service
public interface PictureService {
    List<Picture> findAll();
    Picture findById(Integer id) throws NotFoundException;
    public PictureEntity uploadImage(MultipartFile file) throws IOException, NotFoundException;
    public Picture getInfoByPictureByName(String name);
    }