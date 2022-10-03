package java38team3.ecommerce.controller;


import java38team3.ecommerce.entities.UserEntity;
import java38team3.ecommerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{userId}")
    public UserEntity getUSer(@PathVariable("userId") Long id){
        return userRepository.getById(id);
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity request) {
        return userRepository.save(request);
    }

    @PutMapping("/{userId}")
    public UserEntity updateUser(@PathVariable("userId") Long id,@RequestBody UserEntity request) {
        UserEntity exists = userRepository.findById(id).orElseThrow(()-> new RuntimeException("Entity not found"));
        return userRepository.save(request);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(@PathVariable("userId") Long id){
        UserEntity exists = userRepository.findById(id).orElseThrow(()-> new RuntimeException("Entity not found"));
        userRepository.deleteById(id);
    }

}
