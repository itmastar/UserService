package com.tdemo.user.controller;

import com.tdemo.user.dto.UserDTO;
import com.tdemo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        UserDTO savedUser=userService.saveUser(userDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/findAllUsers")
    public ResponseEntity<List<UserDTO>> findAllUsers(){
       List<UserDTO> allUsers= userService.findAllUsers();
       return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }
    @GetMapping("/fetchUserById/{id}")
    public ResponseEntity<UserDTO> fetchUserById(@PathVariable int id){
        return userService.fetchUserById(id);
    }

}
