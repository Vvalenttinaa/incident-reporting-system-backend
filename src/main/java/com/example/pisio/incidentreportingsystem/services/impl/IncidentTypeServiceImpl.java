package com.example.pisio.incidentreportingsystem.services.impl;

import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.dto.*;
import com.example.pisio.incidentreportingsystem.models.entitets.SubtypeEntity;
import com.example.pisio.incidentreportingsystem.models.entitets.TypeEntity;
import com.example.pisio.incidentreportingsystem.models.requests.IncidentTypeRequest;
import com.example.pisio.incidentreportingsystem.repositories.IncidentSubtypeEntityRepository;
import com.example.pisio.incidentreportingsystem.repositories.IncidentTypeEntityRepository;
import com.example.pisio.incidentreportingsystem.services.IncidentTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncidentTypeServiceImpl implements IncidentTypeService {

    private final ModelMapper modelMapper;
    private final IncidentTypeEntityRepository incidentTypeEntityRepository;
    private final IncidentSubtypeEntityRepository incidentSubtypeEntityRepository;

    public IncidentTypeServiceImpl(ModelMapper modelMapper, IncidentTypeEntityRepository incidentTypeEntityRepository, IncidentSubtypeEntityRepository incidentSubtypeEntityRepository) {
        this.modelMapper = modelMapper;
        this.incidentTypeEntityRepository = incidentTypeEntityRepository;
        this.incidentSubtypeEntityRepository = incidentSubtypeEntityRepository;
    }

    @Override
    public List<IncidentType> findAll() {
        return incidentTypeEntityRepository.findAll().stream().map(l->modelMapper.map(l, IncidentType.class)).collect(Collectors.toList());
    }

    @Override
    public SingleType findById(Integer id) throws NotFoundException {
        return modelMapper.map(incidentTypeEntityRepository.findById(id).orElseThrow(NotFoundException::new), SingleType.class);
    }

    @Override
    public IncidentType insert(IncidentTypeRequest request) throws NotFoundException {
        TypeEntity entity=modelMapper.map(request,TypeEntity.class);
        entity.setId(null);
        entity=incidentTypeEntityRepository.saveAndFlush(entity);
     //   manager.refresh(entity);
        return findById(entity.getId());
    }

}
