package com.devtam.security.repository;

import com.devtam.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    User findById(Long id);
//    boolean save(User user);
}
