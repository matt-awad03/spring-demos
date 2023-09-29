package com.matthewa.restfuldemo.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matthewa.restfuldemo.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
}
