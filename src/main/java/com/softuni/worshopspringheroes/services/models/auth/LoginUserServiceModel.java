package com.softuni.worshopspringheroes.services.models.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginUserServiceModel {

    private String username;
    private String password;
}
