package io.avien.spring.postgres.Employee_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.avien.spring.postgres.Employee_management.entity.User;
import io.avien.spring.postgres.Employee_management.exception.DuplicateEmailException;
import io.avien.spring.postgres.Employee_management.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateEmailException(user.getEmail());
        }
        return userRepository.save(user);
    }
}
