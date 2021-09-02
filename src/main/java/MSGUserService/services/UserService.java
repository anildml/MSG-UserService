package MSGUserService.services;

import MSGUserService.daos.UserDao;
import MSGUserService.helpers.AuthHelper;
import MSGUserService.helpers.DtoMapper;
import MSGUserService.helpers.PasswordHandler;
import MSGUserService.models.dtos.UserDto;
import MSGUserService.models.entities.UserEntity;
import MSGUserService.models.requests.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface UserService {

    String loginAndGetToken(LoginRequest loginRequest);

    Boolean signUp(UserDto userDto);

}

@Service
class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordHandler passwordHandler;

    @Autowired
    private AuthHelper authHelper;

    @Autowired
    private DtoMapper dtoMapper;


    @Override
    public String loginAndGetToken(LoginRequest loginRequest) {
        UserDto userDto = dtoMapper.convertToUserDto(userDao.findUserEntityByUsername(loginRequest.getUsername()));
        if (passwordHandler.doesPasswordsMatch(userDto.getPasswordDigest(), loginRequest.getPassword())) {
            return authHelper.buildTokenForUser(userDto);
        }
        return null;
    }

    @Override
    public Boolean signUp(UserDto userDto) {
        UserEntity userEntity = dtoMapper.convertToEntity(userDto);
        try {
            userDao.save(userEntity);
        } catch (Exception e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
