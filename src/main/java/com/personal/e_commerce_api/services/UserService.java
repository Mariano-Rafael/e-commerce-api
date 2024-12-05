package com.personal.e_commerce_api.services;

import com.personal.e_commerce_api.models.User;
import com.personal.e_commerce_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUseByDocument(String document) {
        return userRepository.findByDocument(document);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(String email, User userDetails) {

        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (userDetails.getName() != null) {
                user.setName(userDetails.getName());
            }
            if (userDetails.getPassword() != null) {
                user.setPassword(userDetails.getPassword());
            }
            if (userDetails.getDocument() != null) {
                user.setDocument(userDetails.getDocument());
            }
            return userRepository.save(user);
        }
        else {
            throw new RuntimeException("User not found with email: " + email);
        }
    }

}
