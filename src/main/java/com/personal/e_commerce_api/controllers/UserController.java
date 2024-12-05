package com.personal.e_commerce_api.controllers;

import com.personal.e_commerce_api.models.User;
import com.personal.e_commerce_api.services.UserService;
import com.personal.e_commerce_api.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User createdUser = userService.createUser(user);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Error registering user: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {
        try {
            Optional<User> optionalUser = userService.getUserByEmail(email);

            if (optionalUser.isPresent()) {
                User user = optionalUser.get();

                if (passwordEncoder.matches(password, user.getPassword())) {
                    String token = jwtUtil.generateToken(email);

                    return ResponseEntity.ok().body("Bearer" + token);
                }
                else {
                    return new ResponseEntity<>("Invalid password.", HttpStatus.UNAUTHORIZED);
                }
            }
            else {
                return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>("Error logging in: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            Optional<User> optionalUser = userService.getUserById(id);

            if (optionalUser.isPresent()) {
                return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("User not found with id: " + id, HttpStatus.NOT_FOUND);
            }
        }
        catch ( Exception e) {
            return new ResponseEntity<>("Error getting user by id: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

