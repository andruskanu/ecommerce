package java38team3.ecommerce.services;

import java38team3.ecommerce.dto.UserDto;
import java38team3.ecommerce.entities.UserEntity;
import java38team3.ecommerce.mapper.UserMapper;
import java38team3.ecommerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity entity= userRepository.findByEmail(username);
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(entity.getRole().name());
                return Collections.singleton(authority);
            }

            @Override
            public String getPassword() {
                return entity.getPassword();
            }

            @Override
            public String getUsername() {
                return entity.getEmail();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }

    public UserDto registerUser(UserDto userDto){
        UserEntity userEntity = userMapper.convertToEntity(userDto);
        userRepository.save(userEntity);
        return userMapper.convertToDto(userEntity);
    }


}
