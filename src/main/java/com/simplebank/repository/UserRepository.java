package com.simplebank.repository;

import com.simplebank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { 

    boolean existsByUsername(String username);
    //Find user
    User findByUsername(String username);
}
