package com.softuni.worshopspringheroes.services.services.implementations;

import com.softuni.worshopspringheroes.repository.UserRepository;
import com.softuni.worshopspringheroes.services.models.auth.RegisterUserServiceModel;
import com.softuni.worshopspringheroes.services.services.AuthValidationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthValidationServiceImpl implements AuthValidationService {

    private UserRepository userRepository;


    @Autowired
    public AuthValidationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(RegisterUserServiceModel userServiceModel) {
        return this.isEmailValid(userServiceModel.getEmail())
                && this.arePasswordsValid(userServiceModel.getPassword(), userServiceModel.getConfirmPassword())
                && this.isUsernameFree(userServiceModel.getUsername());
    }

    private boolean arePasswordsValid(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    private boolean isUsernameFree(String username) {
        return this.userRepository.findByUsername(username).isEmpty();
    }

    private boolean isEmailValid(String email) {
        return true;
    }
}
