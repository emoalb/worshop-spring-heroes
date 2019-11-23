package com.softuni.worshopspringheroes.web.controllers;

import com.softuni.worshopspringheroes.services.models.auth.LoginUserResonceModel;
import com.softuni.worshopspringheroes.services.models.auth.LoginUserServiceModel;
import com.softuni.worshopspringheroes.services.models.auth.RegisterUserServiceModel;
import com.softuni.worshopspringheroes.services.services.AuthService;
import com.softuni.worshopspringheroes.web.models.LoginUserModel;
import com.softuni.worshopspringheroes.web.models.RegisterUserModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class AuthController {
    private AuthService authService;
    private ModelMapper modelMapper;


    @Autowired
    public AuthController(AuthService authService, ModelMapper modelMapper) {

        this.authService = authService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "auth/login.html";
    }

    @GetMapping("/register")
    public String getRegisterForm() {
        return "auth/register.html";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterUserModel model) {
        RegisterUserServiceModel registerUserServiceModel = this.modelMapper.map(model, RegisterUserServiceModel.class);
        this.authService.register(registerUserServiceModel);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginUserModel model, HttpSession httpSession) {

        LoginUserServiceModel loginUserServiceModel = this.modelMapper.map(model, LoginUserServiceModel.class);
        try {
            LoginUserResonceModel loginUserResonceModel = this.authService.login(loginUserServiceModel);
            httpSession.setAttribute("user",loginUserResonceModel);
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/users/login";
        }

    }
}

