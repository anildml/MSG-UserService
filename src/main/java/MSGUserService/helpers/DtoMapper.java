package MSGUserService.helpers;

import MSGUserService.models.dtos.UserDto;
import MSGUserService.models.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

public interface DtoMapper {

    UserEntity convertToEntity(UserDto userDto);

    UserDto convertToUserDto(UserEntity userEntity);

}

@Service
class DtoMapperImpl implements DtoMapper {

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public UserEntity convertToEntity(UserDto userDto) {
        return mapper.map(userDto, UserEntity.class);
    }

    @Override
    public UserDto convertToUserDto(UserEntity userEntity) {
        return mapper.map(userEntity, UserDto.class);
    }
}
