package MSGUserService.services;

import MSGUserService.daos.UserDao;
import MSGUserService.helpers.AuthHelper;
import MSGUserService.helpers.DtoMapper;
import MSGUserService.helpers.PasswordHandler;
import MSGUserService.models.dtos.UserDto;
import MSGUserService.models.entities.UserEntity;
import MSGUserService.models.errors.login.LoginError;
import MSGUserService.models.errors.login.InvalidPasswordError;
import MSGUserService.models.errors.login.InvalidUsernameError;
import MSGUserService.models.requests.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordHandler passwordHandler;

    @Autowired
    private AuthHelper authHelper;

    @Autowired
    private DtoMapper dtoMapper;

    public String loginAndGetToken(LoginRequest loginRequest) {
        UserEntity userEntity = null;
        try {
            userEntity = userDao.findUserEntityByUsername(loginRequest.getUsername());
        } catch (Exception e) {
            // DATABASE ACCESS PROBLEM
            // THROW GENERIC ERROR
        }
        if (userEntity == null) {
            throw new InvalidUsernameError();
        }
        UserDto userDto = dtoMapper.convertToUserDto(userEntity);
        boolean isPasswordsMatch =
                passwordHandler.doesPasswordsMatch(userDto.getPasswordDigest(), loginRequest.getPassword());
        if (!isPasswordsMatch) {
            throw new InvalidPasswordError();
        }
        return authHelper.buildTokenForUser(userDto);
    }

}
