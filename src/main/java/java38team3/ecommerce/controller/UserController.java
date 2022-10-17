package java38team3.ecommerce.controller;


import java38team3.ecommerce.dto.RegisterDto;
import java38team3.ecommerce.dto.UserDto;
import java38team3.ecommerce.entities.UserEntity;
import java38team3.ecommerce.repository.UserRepository;
import java38team3.ecommerce.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    private final UserService userService;

//    @PostMapping
//    public ResponseEntity<UserDto> register(@RequestBody RegisterDto registerDto) {
//
//    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public UserEntity getUser(@PathVariable("userId") Long id){
        return userRepository.getById(id);
    }


    @PostMapping()
    public UserDto createUser(@RequestBody UserDto userDto) {
        UserDto newUserDto = userService.registerUser(userDto);
        return newUserDto;
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
