package com.devtam.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenController {
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("email") String email, @ModelAttribute("password") String password){
        System.out.println("Email: " + email + "\nPassword: " + password);
        return "index";
    }
    @GetMapping("/home")
    public String home(){
        return "index";
    }
}
