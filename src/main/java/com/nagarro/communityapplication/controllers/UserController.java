package com.nagarro.communityapplication.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/welcome")
    public String Welcome()
    {
        return "This is an User Welcome api";
    }
    
}
