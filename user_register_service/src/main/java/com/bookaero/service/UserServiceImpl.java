package com.bookaero.service;

import com.bookaero.entity.User;
import com.bookaero.exception.DuplicateFieldException;
import com.bookaero.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.faulttolerance.Retry;

@ApplicationScoped
public class UserServiceImpl implements UserService {
    @Inject
    UserRepository userRepository;

    @Override
    @Retry(maxRetries = 3, delay = 1000)
    public User userRegister(User user) throws DuplicateFieldException {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email must not be empty");
        }

        if (userRepository.find("userName", user.getUserName()).firstResultOptional().isPresent()) {
            throw new DuplicateFieldException("Username already exists");
        }

        if (userRepository.find("email", user.getEmail()).firstResultOptional().isPresent()) {
            throw new DuplicateFieldException("Email already exists");
        }

        if (userRepository.find("mobileNumber", user.getMobileNumber()).firstResultOptional().isPresent()) {
            throw new DuplicateFieldException("Mobile number already exists");
        }

        userRepository.persist(user);
        return user;
    }
}