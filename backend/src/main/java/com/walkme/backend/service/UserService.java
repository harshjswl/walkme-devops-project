package com.walkme.backend.service;

import com.walkme.backend.model.User;
import com.walkme.backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, String email) {
        log.info("Creating user with email={}", email);

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email must not be empty");
        }

        User user = new User(name, email);
        return userRepository.save(user);
    }

    public User getUserById(String id) {
        log.info("Fetching user by id={}", id);

        Optional<User> userOpt = userRepository.findById(id);

        if (userOpt.isEmpty()) {
            log.warn("User not found for id={}", id);
            throw new RuntimeException("User not found");
        }

        return userOpt.get();
    }
}
