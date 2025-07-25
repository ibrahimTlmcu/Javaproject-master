package com.example.backend.repositories;

import com.example.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepositories extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}