package com.example.pisio.incidentreportingsystem.services.impl;

import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.dto.Address;
import com.example.pisio.incidentreportingsystem.models.dto.Picture;
import com.example.pisio.incidentreportingsystem.models.dto.SingleAddress;
import com.example.pisio.incidentreportingsystem.models.entitets.PictureEntity;
import com.example.pisio.incidentreportingsystem.repositories.PictureEntityRepository;
import com.example.pisio.incidentreportingsystem.services.PictureService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureEntityRepository pictureEntityRepository;

    private final
    ModelMapper modelMapper;

    public PictureServiceImpl(PictureEntityRepository imageDataRepository, ModelMapper modelMapper) {
        this.pictureEntityRepository = imageDataRepository;
        this.modelMapper = modelMapper;
    }

    public PictureEntity uploadImage(MultipartFile file) throws IOException, NotFoundException {

        PictureEntity pictureEntity = new PictureEntity();
        pictureEntity.setName(file.getOriginalFilename());
        pictureEntity.setType(file.getContentType());
        pictureEntity.setImageData(file.getBytes());
        return pictureEntityRepository.saveAndFlush(pictureEntity);

    //    return findById(pictureEntity.getId());

    }

    @Override
    public Picture getInfoByPictureByName(String name) {
        Optional<PictureEntity> dbImage = pictureEntityRepository.findByName(name);

        Picture picture = new Picture();
        picture.setName(dbImage.get().getName());
        picture.setType(dbImage.get().getType());
        picture.setImageData(dbImage.get().getImageData());

        return picture;
    }

    @Override
    public Picture findById(Integer id) throws NotFoundException {
        return modelMapper.map(pictureEntityRepository.findById(id).orElseThrow(NotFoundException::new), Picture.class);
    }

    @Override
    public List<Picture> findAll() {
        return pictureEntityRepository.findAll().stream().map(l->modelMapper.map(l, Picture.class)).collect(Collectors.toList());
    }

}