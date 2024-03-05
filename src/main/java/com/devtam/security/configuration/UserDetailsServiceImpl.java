package com.devtam.security.configuration;

import com.devtam.security.entity.User;
import com.devtam.security.repository.UserRepository;
import com.devtam.security.util.RoleConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    DataSource dataSource;

    @Autowired
    UserRepository userRepository;
    UserDetailsServiceImpl(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username);
        if(user != null){
            return buildUserForAuthentication(user);
        }
        return null;
    }
    private UserDetails buildUserForAuthentication(User user){
        try {
            UserDetails builder =
                    org.springframework.security.core.userdetails.User.builder().username(user.getEmail())
                            .password(user.getPassword())
                            .roles(RoleConstant.getObjectName(user.getRole()))
                            .authorities(RoleConstant.getObjectName(user.getRole())).build();
            return builder;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
