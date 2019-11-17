package com.softuni.worshopspringheroes.repository;

import com.softuni.worshopspringheroes.domain.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
List<User> getUserList();

}
