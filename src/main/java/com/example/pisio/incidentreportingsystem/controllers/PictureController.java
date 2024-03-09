package com.example.pisio.incidentreportingsystem.controllers;

import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.dto.Picture;
import com.example.pisio.incidentreportingsystem.models.entitets.PictureEntity;
import com.example.pisio.incidentreportingsystem.services.PictureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class PictureController {

    private final PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @PostMapping
    public PictureEntity uploadImage(@RequestParam("image") MultipartFile file) throws IOException, NotFoundException {
        return pictureService.uploadImage(file);
    }

    @GetMapping("/info/{name}")
    public ResponseEntity<?>  getImageInfoByName(@PathVariable("name") String name){
        Picture picture = pictureService.getInfoByPictureByName(name);
        return ResponseEntity.status(HttpStatus.OK)
                .body(picture);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  getImageByName(@PathVariable("id") Integer id) throws NotFoundException {
        Picture picture = pictureService.findById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(picture.getImageData());
    }
}