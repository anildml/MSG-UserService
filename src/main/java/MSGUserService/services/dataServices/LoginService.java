package MSGUserService.services.dataServices;

import MSGUserService.daos.UserDao;
import MSGUserService.services.helpers.AuthHelper;
import MSGUserService.services.helpers.PasswordHandler;
import MSGUserService.models.dtos.UserDto;
import MSGUserService.models.entities.UserEntity;
import MSGUserService.models.errors.login.InvalidPasswordError;
import MSGUserService.models.errors.login.InvalidUsernameError;
import MSGUserService.models.requests.LoginRequest;
import org.modelmapper.ModelMapper;
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
    private ModelMapper mapper;

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
        UserDto userDto = mapper.map(userEntity, UserDto.class);
        boolean isPasswordsMatch =
                passwordHandler.doesPasswordsMatch(userDto.getPasswordDigest(), loginRequest.getPassword());
        if (!isPasswordsMatch) {
            throw new InvalidPasswordError();
        }
        return authHelper.buildTokenForUser(userDto);
    }

}
