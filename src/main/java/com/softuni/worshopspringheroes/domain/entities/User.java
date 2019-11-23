package com.softuni.worshopspringheroes.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;

    @OneToOne(mappedBy = "user")
    private Hero hero;

}
