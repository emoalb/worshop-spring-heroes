package com.softuni.worshopspringheroes.services.models.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class LoginUserResonceModel {
    private String username;
    private String heroName;

    public LoginUserResonceModel(String username, String heroName) {
        this.username = username;
        this.heroName = heroName;
    }
}
