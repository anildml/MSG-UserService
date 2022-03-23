package MSGUserService.helpers;

import MSGUserService.models.dtos.UserDto;
import MSGUserService.models.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DtoMapper {

    private final ModelMapper mapper = new ModelMapper();

    public UserEntity convertToEntity(UserDto userDto) {
        return mapper.map(userDto, UserEntity.class);
    }

    public UserDto convertToUserDto(UserEntity userEntity) {
        return mapper.map(userEntity, UserDto.class);
    }

}
