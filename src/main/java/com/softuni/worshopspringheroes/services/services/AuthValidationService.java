package com.softuni.worshopspringheroes.services.services;

import com.softuni.worshopspringheroes.services.models.auth.RegisterUserServiceModel;

public interface AuthValidationService {
    boolean isValid(RegisterUserServiceModel userServiceModel);

}
