package com.m2i.woof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.m2i.woof.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByIdentifiant(String username);
}
