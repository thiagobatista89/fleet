package com.fleet.api.controllers;

import com.fleet.api.entities.UserEntity;
import com.fleet.api.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class UserControllers {
    // TODO: Controller não pode chamar o repository, não é boa pratica, use service para bussines
    private final UserRepository userRepository;

    public UserControllers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping // TODO rever a forma correta de usar o Response Entity
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok(this.userRepository.findAll());
    }

    @PostMapping // TODO; the same up
    public ResponseEntity save(@RequestBody UserEntity user) {
        try {
            // Salvar o usuário no banco de dados usando o UserRepository
            UserEntity savedUser = userRepository.save(user);

            // Retorna a resposta com status 201 Created e o objeto salvo
            return ResponseEntity.status(201).body(savedUser);
        } catch (Exception e) {
            // Em caso de erro, retorna uma resposta com status 500 Internal Server Error
            return ResponseEntity.status(500).body("Erro ao salvar o usuário");
        }
    }
}
