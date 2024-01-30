package com.br.crudusers.services;

import com.br.crudusers.entities.user.User;
import com.br.crudusers.entities.user.UserDTO;
import com.br.crudusers.repositories.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID createUser(@RequestBody UserDTO userDTO) {

        var user = new User(UUID.randomUUID(), userDTO.username(), userDTO.email(), userDTO.password(), Instant.now(), null);

        var userSaved = userRepository.save(user);

        return userSaved.getUserId();
    }

    public Optional<User> getUserById(UUID userId) {
        return userRepository.findById(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void updateUserById(UUID userId, UserDTO userDTO) {

        var userExists = userRepository.findById(userId);

        if (userExists.isPresent()) {
            var user = userExists.get();

            if (userDTO.username() != null || userDTO.username() != "") {
                user.setUsername(userDTO.username());
            }

            if (userDTO.password() != null || userDTO.password() != "") {
                user.setPassword(userDTO.password());
            }

            userRepository.save(user);
        }

    }

    public void deleteUserById(UUID userId) {

        var userExists = userRepository.existsById(userId);

        if (userExists) {
          userRepository.deleteById(userId);
        }
    }

}
