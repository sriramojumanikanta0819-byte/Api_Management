package com.app.Api_Management.controller;

import com.app.Api_Management.exceptions.DuplicateResourceException;
import com.app.Api_Management.exceptions.ResourceNotFoundException;
import com.app.Api_Management.model.User;
import com.app.Api_Management.repo.UserRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {

        if (repository.existsByEmail(user.getEmail())) {
            throw new DuplicateResourceException(
                    "Email already exists: " + user.getEmail());
        }

        return repository.save(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id));
    }

    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @Valid @RequestBody User user) {

        User existingUser = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id));

        if (!existingUser.getEmail().equals(user.getEmail())
                && repository.existsByEmail(user.getEmail())) {

            throw new DuplicateResourceException(
                    "Email already exists: " + user.getEmail());
        }

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        return repository.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {

        User existingUser = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + id));

        repository.delete(existingUser);

        return "Deleted Successfully";
    }
}