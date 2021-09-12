package MSGUserService.services;

import MSGUserService.daos.UserDao;
import MSGUserService.helpers.AuthHelper;
import MSGUserService.helpers.DtoMapper;
import MSGUserService.helpers.PasswordHandler;
import MSGUserService.models.dtos.UserDto;
import MSGUserService.models.entities.UserEntity;
import MSGUserService.models.exceptions.login.LoginException;
import MSGUserService.models.exceptions.login.PasswordsDoesNotMatchException;
import MSGUserService.models.exceptions.login.UserNotFoundException;
import MSGUserService.models.requests.LoginRequest;
import MSGUserService.models.requests.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface LoginService {

    String loginAndGetToken(LoginRequest loginRequest) throws LoginException;

}

@Service
class LoginServiceImpl implements LoginService {

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
        UserEntity userEntity = null;
        try {
            userEntity = userDao.findUserEntityByUsername(loginRequest.getUsername());
        } catch (Exception e) {
            // DATABASE ACCESS PROBLEM
            // THROW GENERIC ERROR
        }
        if (userEntity == null) {
            throw new UserNotFoundException();
        }
        UserDto userDto = dtoMapper.convertToUserDto(userEntity);
        boolean isPasswordsMatch =
                passwordHandler.doesPasswordsMatch(userDto.getPasswordDigest(), loginRequest.getPassword());
        if (isPasswordsMatch) {
            return authHelper.buildTokenForUser(userDto);
        }
        throw new PasswordsDoesNotMatchException();
    }

}
