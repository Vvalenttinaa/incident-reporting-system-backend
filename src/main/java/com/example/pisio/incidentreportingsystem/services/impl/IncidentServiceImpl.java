package com.example.pisio.incidentreportingsystem.services.impl;

import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.dto.Incident;
import com.example.pisio.incidentreportingsystem.models.entitets.*;
import com.example.pisio.incidentreportingsystem.models.requests.IncidentRequest;
import com.example.pisio.incidentreportingsystem.repositories.*;
import com.example.pisio.incidentreportingsystem.services.AddressService;
import com.example.pisio.incidentreportingsystem.services.IncidentService;
import com.example.pisio.incidentreportingsystem.services.PictureService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class IncidentServiceImpl implements IncidentService {
    private final ModelMapper modelMapper;
    private final IncidentEntityRepository incidentEntityRepository;
    private final IncidentTypeEntityRepository typeEntityRepository;
    private final PictureEntityRepository pictureEntityRepository;

    private final  AddressEntityRepository addressEntityRepository;

    private final IncidentSubtypeEntityRepository subtypeEntityRepository;

    private final AddressService addressService;
    private final PictureService pictureService;
    @PersistenceContext
    private EntityManager manager;

    public IncidentServiceImpl(ModelMapper modelMapper, IncidentEntityRepository incidentEntityRepository, IncidentTypeEntityRepository typeEntityRepository, PictureEntityRepository pictureEntityRepository, AddressEntityRepository addressEntityRepository, IncidentSubtypeEntityRepository subtypeEntityRepository, AddressService addressService, PictureService pictureService) {
        this.modelMapper = modelMapper;
        this.incidentEntityRepository = incidentEntityRepository;
        this.typeEntityRepository = typeEntityRepository;
        this.pictureEntityRepository = pictureEntityRepository;
        this.addressEntityRepository = addressEntityRepository;
        this.subtypeEntityRepository = subtypeEntityRepository;
        this.addressService = addressService;
        this.pictureService = pictureService;
    }

    @Override
    public List<Incident> findAll() {
        return incidentEntityRepository.findAll().stream().map(l->modelMapper.map(l, Incident.class)).collect(Collectors.toList());
    }

    @Override
    public Incident findById(Integer id) throws NotFoundException {
        return modelMapper.map(incidentEntityRepository.findById(id).orElseThrow(NotFoundException::new), Incident.class);
    }

    @Override
    public List<Incident> findAllApproved(Boolean approved) throws NotFoundException {
        return incidentEntityRepository.findAllByApproved(true).stream().map(l->modelMapper.map(l, Incident.class)).collect(Collectors.toList());
    }

    @Override
    public List<Incident> findAllNotApproved(Boolean approved) throws NotFoundException {
        return incidentEntityRepository.findAllByApproved(null).stream().map(l->modelMapper.map(l, Incident.class)).collect(Collectors.toList());
    }

    @Override
    public List<Incident> findAllRejected(Boolean approved) throws NotFoundException {
        return incidentEntityRepository.findAllByApproved(false).stream().map(l->modelMapper.map(l, Incident.class)).collect(Collectors.toList());
    }

    @Override
    public Incident insert(IncidentRequest request) throws NotFoundException, IOException {
        IncidentEntity entity=modelMapper.map(request,IncidentEntity.class);

        TypeEntity typeEntity = typeEntityRepository.findById(request.getType()).get();
        if (request.getSubtype()!=null) {
            SubtypeEntity subtypeEntity = subtypeEntityRepository.findById(request.getSubtype()).get();
            entity.setSubtype(subtypeEntity);
        }
      //  if (file != null) {
       //     entity.setPicture(pictureService.uploadImage(file));
           /*
           PictureEntity pictureEntity = new PictureEntity();
            pictureEntity.setId(null);
            pictureEntity.setName(request.getPicture().getName());
            pictureEntity.setType(request.getPicture().getType());
            pictureEntity.setImageData(request.getPicture().getImageData());
            PictureEntity pictureEntity1 = pictureEntityRepository.saveAndFlush(pictureEntity);
            entity.setPicture(pictureEntity1);
            */
      //  }
//        manager.refresh(pictureEntity);

        AddressEntity entityAddress = new AddressEntity();
        entityAddress.setLatitude(request.getLatitude());
        entityAddress.setLongitude(request.getLongitude());
        entityAddress.setName(request.getAddressName());

        Optional<AddressEntity> addressEntity= addressEntityRepository.findIdByNameAndLatAndLng(entityAddress.getName(),
                entityAddress.getLatitude(), entityAddress.getLongitude());
        if(!addressEntity.isPresent()) {
           /* Address a = new Address();
            a.setName(request.getAddressName());
            a.setLatitude(request.getLatitude());
            a.setLongitude(request.getLongitude());

            entityAddress.setId(null);
            entityAddress = addressEntityRepository.saveAndFlush(entityAddress);
            entity.setAddress(entityAddress);*/
            entityAddress.setId(null);
            String[] parts =  request.getAddressName().split(",");
            String pom = parts[1].trim();
            pom = pom.replaceAll("\\d", "");
            entityAddress.setPlace(pom);
            entityAddress = addressEntityRepository.saveAndFlush(entityAddress);
            entity.setAddress(entityAddress);
        }else {
            entity.setAddress(addressEntity.orElse(null));
        }

        entity.setId(null);
        entity.setApproved(null);
        entity.setType(typeEntity);

        if(request.getImageId() != null) {
            Optional<PictureEntity> picture = pictureEntityRepository.findById(request.getImageId());
            entity.setPicture(picture.orElse(null));
        }


        entity=incidentEntityRepository.saveAndFlush(entity);
     //   manager.refresh(entity);
        return findById(entity.getId());
    }

    @Override
    public void approveIncident(Integer id) {
        IncidentEntity incidentEntity = incidentEntityRepository.findById(id).orElse(null);
        if(incidentEntity != null)
        {
            incidentEntity.setApproved(true);
            incidentEntityRepository.saveAndFlush(incidentEntity);
        }
    }
    @Override
    public void rejectIncident(Integer id) {
        IncidentEntity incidentEntity = incidentEntityRepository.findById(id).orElse(null);
        if(incidentEntity != null)
        {
            incidentEntity.setApproved(false);
            incidentEntityRepository.saveAndFlush(incidentEntity);
        }
    }

    @Override
    public void deleteIncident(Integer id){
        IncidentEntity incidentEntity = incidentEntityRepository.findById(id).get();
        incidentEntityRepository.delete(incidentEntity);
    }
}
