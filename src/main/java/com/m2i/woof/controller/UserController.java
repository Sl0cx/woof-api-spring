package com.m2i.woof.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.woof.dto.DogDto;
import com.m2i.woof.model.User;
import com.m2i.woof.service.UserServiceImpl;
import com.m2i.woof.service.security.JwtService;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    
    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public String login(Authentication authentication){
        return jwtService.generateToken(authentication);
    }

    @PostMapping("/inscription")
    public User inscription(@RequestBody User user){
        return userService.inscription(user);
    }
}
