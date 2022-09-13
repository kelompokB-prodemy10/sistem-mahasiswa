package com.kelompokb.sistemmahasiswabackend.repository;


import com.kelompokb.sistemmahasiswabackend.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);

    Optional<User> findByPassword(String password);
}
