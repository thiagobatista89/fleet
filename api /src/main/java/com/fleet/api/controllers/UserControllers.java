package com.fleet.api.controllers;

import com.fleet.api.entities.UserEntity;
import com.fleet.api.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class UserControllers {

    private final UserRepository userRepository;

    public UserControllers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok(this.userRepository.findAll());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody UserEntity user) {
        try {

            UserEntity savedUser = userRepository.save(user);

            return ResponseEntity.status(201).body(savedUser);
        } catch (Exception e) {

            return ResponseEntity.status(500).body("Erro ao salvar o usuário");
        }
    }
}
