package com.example.demoHostel.repo;

import com.example.demoHostel.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<user,Long> {
    user findByEmail(String email);

    Optional<user> findByUsername(String username);
}
