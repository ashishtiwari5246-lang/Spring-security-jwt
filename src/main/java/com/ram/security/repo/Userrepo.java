package com.ram.security.repo;

import com.ram.security.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
