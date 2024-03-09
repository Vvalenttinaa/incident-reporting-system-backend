package com.example.pisio.incidentreportingsystem.services.impl;

import com.example.pisio.incidentreportingsystem.enums.Role;
import com.example.pisio.incidentreportingsystem.exceptions.NotFoundException;
import com.example.pisio.incidentreportingsystem.models.dto.User;
import com.example.pisio.incidentreportingsystem.repositories.UserEntityRepository;
import com.example.pisio.incidentreportingsystem.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserEntityRepository userEntityRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserEntityRepository userEntityRepository, ModelMapper modelMapper) {
        this.userEntityRepository = userEntityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<User> findAll() {
        return userEntityRepository.findAll().stream().map(l->modelMapper.map(l, User.class)).collect(Collectors.toList());
    }

    @Override
    public User findById(Integer id) throws NotFoundException {
        User user = modelMapper.map(userEntityRepository.findById(id).orElseThrow(NotFoundException::new), User.class);

        return setUserRole(user);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) throws NotFoundException {
        User user = modelMapper.map(userEntityRepository.findByUsernameAndPassword(username, password).orElseThrow(NotFoundException::new), User.class);

        return setUserRole(user);
    }

    @Override
    public User findByUsername(String username) throws NotFoundException {
        User user = modelMapper.map(userEntityRepository.findByUsername(username).orElseThrow(NotFoundException::new), User.class);
        return setUserRole(user);
    }

    private User setUserRole(User user) {
        if(user.getRoleId()==1){
            user.setRole(String.valueOf(Role.ADMIN));
        }else if(user.getRoleId()==2){
            user.setRole(String.valueOf(Role.USER));
        }else if(user.getRoleId()==3){
            user.setRole(String.valueOf(Role.USER_WITH_ACCOUNT));
        }
        return user;
    }
}
