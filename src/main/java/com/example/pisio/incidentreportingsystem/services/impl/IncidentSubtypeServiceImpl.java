package com.example.pisio.incidentreportingsystem.services.impl;

import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.dto.IncidentSubtype;
import com.example.pisio.incidentreportingsystem.models.dto.SingleAddress;
import com.example.pisio.incidentreportingsystem.models.dto.SingleSubtype;
import com.example.pisio.incidentreportingsystem.repositories.IncidentSubtypeEntityRepository;
import com.example.pisio.incidentreportingsystem.services.IncidentSubtypeService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.pisio.incidentreportingsystem.models.entitets.SubtypeEntity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncidentSubtypeServiceImpl implements IncidentSubtypeService {

    private final ModelMapper modelMapper;
    private final IncidentSubtypeEntityRepository incidentSubtypeEntityRepository;

    @PersistenceContext
    private EntityManager manager;

    public IncidentSubtypeServiceImpl(ModelMapper modelMapper, IncidentSubtypeEntityRepository incidentSubtypeEntityRepository) {
        this.modelMapper = modelMapper;
        this.incidentSubtypeEntityRepository = incidentSubtypeEntityRepository;
    }

    @Override
    public List<IncidentSubtype> findAll() {
        return incidentSubtypeEntityRepository.findAll().stream().map(l->modelMapper.map(l, IncidentSubtype.class)).collect(Collectors.toList());

    }
    @Override
    public SingleSubtype findById(Integer id) throws NotFoundException {
        return modelMapper.map(incidentSubtypeEntityRepository.findById(id).orElseThrow(NotFoundException::new), SingleSubtype.class);
    }

    @Override
    public IncidentSubtype insert(IncidentSubtype incidentSubtype) throws NotFoundException {
        SubtypeEntity entity=modelMapper.map(incidentSubtype, SubtypeEntity.class);
        entity.setId(null);
        entity=incidentSubtypeEntityRepository.saveAndFlush(entity);
    //    manager.refresh(entity);
       // return findById(entity.getId());
        return modelMapper.map(incidentSubtypeEntityRepository.findById(entity.getId()).orElseThrow(NotFoundException::new), IncidentSubtype.class);

    }

    @Override
    public List<IncidentSubtype> findAllSubtypesByTypeId(Integer id) throws NotFoundException {
        return incidentSubtypeEntityRepository.findAllByTypeId(id).stream().map(l->modelMapper.map(l, IncidentSubtype.class)).collect(Collectors.toList());
    }
}
