package com.board1.controller;

import com.board1.dto.UserDTO;
import com.board1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class BlogController {

    @Autowired
    private UserService userService;


    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {

        userService.createUser(userDTO);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }
}



