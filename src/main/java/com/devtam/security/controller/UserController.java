package com.devtam.security.controller;

import com.devtam.security.entity.User;
import com.devtam.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<User> getListUsers(){
        return null;
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUsers(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }
}
