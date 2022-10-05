package java38team3.ecommerce.mapper;

import java38team3.ecommerce.dto.UserDto;
import java38team3.ecommerce.entities.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserMapper implements Mapper<UserEntity, UserDto>{

    @Override
    public UserDto convertToDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPassword(userEntity.getPassword());
        userDto.setRole(userEntity.getRole());
        return userDto;
    }

    @Override
    public UserEntity convertToEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setRole(userDto.getRole());
        return userEntity;
    }
}
// FRONT END -> Controller -> Service -> DTOtoEntity -> Repository -> Entity ->
//
// Entity -> Repository -> EntityToDTO -> Service -> Controller -> FRONT END