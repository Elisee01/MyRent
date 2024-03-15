package com.seedafricaorgtech.MyRent.service.api.repository;


import com.seedafricaorgtech.MyRent.service.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}

