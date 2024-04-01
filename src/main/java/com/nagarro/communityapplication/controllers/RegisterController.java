package com.nagarro.communityapplication.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.communityapplication.dto.SignUpDto;
import com.nagarro.communityapplication.entities.User;

import com.nagarro.communityapplication.repository.UserRepository;

//public controller 
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/register")
public class RegisterController {

  @Autowired
  UserRepository userRepository;


    @PostMapping("/new")
    private ResponseEntity<?> register(@RequestBody SignUpDto signUpDto)
    {

       // add check for username exists in a DB
        if(userRepository.existsByUsername(signUpDto.getName())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setUsername(signUpDto.getName());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(signUpDto.getPassword());
        user.setAge(signUpDto.getAge());
        user.setPhonenumber(signUpDto.getPhonenumber());
        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
    
}
