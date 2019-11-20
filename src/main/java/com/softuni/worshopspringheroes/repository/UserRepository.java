package com.softuni.worshopspringheroes.repository;

import com.softuni.worshopspringheroes.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByUsernameAndPassword(String username,String password);

}
