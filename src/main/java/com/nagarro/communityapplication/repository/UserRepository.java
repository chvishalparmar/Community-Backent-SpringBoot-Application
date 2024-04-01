package com.nagarro.communityapplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.nagarro.communityapplication.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {   

    List<User> findByUsername(String username);
    List<User> findByEmail(String email);
    Optional <User> findByUsernameOrEmail(String username, String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
