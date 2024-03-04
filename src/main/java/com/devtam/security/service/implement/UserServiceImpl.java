package com.devtam.security.service.implement;


import com.devtam.security.entity.User;
import com.devtam.security.repository.UserRepository;
import com.devtam.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseEntity<User> getUserById(Long id) {
        try {
            Optional<User> user = userRepository.findById(id);
            return ResponseEntity.ok(user.get());
        }
        catch (NullPointerException e){
            System.err.println(e.getMessage());
            return ResponseEntity.ofNullable(null);
        }

    }
    @Override
    public User getUserByEmail(String email) {
        try {
            User user = userRepository.findUserByEmail(email);
            return user;
        }
        catch (NullPointerException e){
            System.err.println(e.getMessage());
            return null;
        }
    }
}
