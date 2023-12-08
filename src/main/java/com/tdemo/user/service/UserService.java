package com.tdemo.user.service;

import com.tdemo.user.dto.UserDTO;
import com.tdemo.user.entity.User;
import com.tdemo.user.mapper.UserMapper;
import com.tdemo.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public UserDTO saveUser(UserDTO userDTO) {
        User savedUser = userRepo.save(UserMapper.INSTANCE.userDTOtoUser(userDTO));
        return UserMapper.INSTANCE.usertoUserDTO(savedUser);
    }

    public List<UserDTO> findAllUsers() {
        List<User> allUsers = userRepo.findAll();
        return allUsers.stream().map(UserMapper.INSTANCE::usertoUserDTO).toList();
    }

    public ResponseEntity<UserDTO> fetchUserById(int id) {

        Optional<User> user = userRepo.findById(id);
        return user.map(value -> new ResponseEntity<>(UserMapper.INSTANCE.usertoUserDTO(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
