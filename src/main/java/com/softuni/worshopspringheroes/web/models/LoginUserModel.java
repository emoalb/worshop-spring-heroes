package com.softuni.worshopspringheroes.web.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class LoginUserModel {
    private String username;
    private String password;
}
