package java38team3.ecommerce.services;

import java38team3.ecommerce.dto.UserDto;
import java38team3.ecommerce.entities.UserEntity;
import java38team3.ecommerce.mapper.UserMapper;
import java38team3.ecommerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserDto registerUser(UserDto userDto){
        UserEntity userEntity = userMapper.convertToEntity(userDto);
        userRepository.save(userEntity);
        return userDto;
    }


}
