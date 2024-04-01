package com.nagarro.communityapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.communityapplication.repository.ProductRepository;
import com.nagarro.communityapplication.repository.ReviewRepository;
import com.nagarro.communityapplication.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @GetMapping("/members")
    private ResponseEntity<?> member()
    {
        return new ResponseEntity<Object>(userRepository.count(),HttpStatus.OK);
    }

    @GetMapping("/products")
    private ResponseEntity<?> product()
    {
        return new ResponseEntity<Object>(productRepository.count(),HttpStatus.OK);
    }

    @GetMapping("/reviews")
    private ResponseEntity<?> review()
    {
        return new ResponseEntity<Object>(reviewRepository.count(),HttpStatus.OK);

    }
    
}
