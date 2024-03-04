package com.devtam.security.service;


import com.devtam.security.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public ResponseEntity<User> getUserById(Long id);
    public User getUserByEmail(String email);
}
