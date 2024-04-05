package com.react_formation.react_formation.controllers;

import com.react_formation.react_formation.DTO.requestsDTO.UserRequestDTO;
import com.react_formation.react_formation.DTO.responseDTO.UserResponseDTO;
import com.react_formation.react_formation.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        UserResponseDTO user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        userService.saveUsser(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("this user has been created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFormation(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        userService.updateUser(id, userRequestDTO);
        return ResponseEntity.ok("user has been updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFormation(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("user has been deleted");
    }

}
