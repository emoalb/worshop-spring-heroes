package com.softuni.worshopspringheroes.services.services;

import com.softuni.worshopspringheroes.services.models.auth.LoginUserResonceModel;
import com.softuni.worshopspringheroes.services.models.auth.LoginUserServiceModel;
import com.softuni.worshopspringheroes.services.models.auth.RegisterUserServiceModel;

public interface AuthService {
    void register(RegisterUserServiceModel model);

    LoginUserResonceModel login(LoginUserServiceModel loginUserServiceModel) throws Exception;
}
