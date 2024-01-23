package com.devtam.security.configuration;


import com.devtam.security.entity.User;
import com.devtam.security.repository.UserRepository;
import com.devtam.security.util.RoleConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class ApplicationConfig implements WebMvcConfigurer {
    @Autowired
    UserRepository userRepository;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/static/**")
                .addResourceLocations("/resources/static/");
    }


    @Bean
    CommandLineRunner addNewUser(){
        return args -> {
            User new1 = User.builder()
                    .id(1L)
                    .email("nguyentrongtam2x2@gmail.com")
                    .name("Nguyen Trong Tu Tam")
                    .password("123456")
                    .phoneNumber("0565459651")
                    .role(RoleConstant.ROOT.getValue())
                    .build();
            User new2 = User.builder()
                    .id(2L)
                    .email("namancut@gmail.com")
                    .name("Hoang Duc Nam")
                    .password("123456")
                    .phoneNumber("0435253233")
                    .role(RoleConstant.ROOT.getValue())
                    .build();

            saveUser(new1);
            saveUser(new2);
        };
    }
    private boolean saveUser(User user){
        if(userRepository.save(user) != null){
            System.out.println("saved " + user.getEmail());
            return true;
        }
        else {
            System.out.println("couldn't save " + user.getEmail());
            return false;
        }
    }
}
