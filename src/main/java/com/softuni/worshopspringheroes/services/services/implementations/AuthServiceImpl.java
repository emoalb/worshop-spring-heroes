package com.softuni.worshopspringheroes.services.services.implementations;

import com.softuni.worshopspringheroes.domain.entities.User;
import com.softuni.worshopspringheroes.repository.UserRepository;
import com.softuni.worshopspringheroes.services.models.auth.LoginUserServiceModel;
import com.softuni.worshopspringheroes.services.models.auth.RegisterUserServiceModel;
import com.softuni.worshopspringheroes.services.services.AuthService;
import com.softuni.worshopspringheroes.services.services.AuthValidationService;
import com.softuni.worshopspringheroes.services.services.HashingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthValidationService authValidationService;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private HashingService hashingService;

    @Autowired
    public AuthServiceImpl(AuthValidationService authValidationService, UserRepository userRepository, ModelMapper modelMapper, HashingService hashingService) {
        this.authValidationService = authValidationService;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.hashingService = hashingService;
    }

    @Override
    public void register(RegisterUserServiceModel model) {
        if (!authValidationService.isValid(model)) {
            return;
        }
        User user = modelMapper.map(model, User.class);
        user.setPassword(this.hashingService.hash(user.getPassword()));
        this.userRepository.save(user);
    }

    @Override
    public void login(LoginUserServiceModel loginUserServiceModel) throws Exception {
if(!userRepository.existsByUsernameAndPassword(loginUserServiceModel.getUsername(),
        this.hashingService.hash(loginUserServiceModel.getPassword()))){
    throw new Exception("Invalid user");
        }

    }
}
