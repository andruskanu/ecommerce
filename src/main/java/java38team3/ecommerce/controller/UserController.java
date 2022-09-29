package java38team3.ecommerce.controller;


import java38team3.ecommerce.entities.UserEntity;
import java38team3.ecommerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserRepository userRepository;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity request) {
        return userRepository.save(request);
    }
}
