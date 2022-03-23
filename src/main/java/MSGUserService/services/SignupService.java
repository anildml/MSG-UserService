package MSGUserService.services;

import MSGUserService.daos.UserDao;
import MSGUserService.helpers.DtoMapper;
import MSGUserService.helpers.PasswordHandler;
import MSGUserService.models.dtos.UserDto;
import MSGUserService.models.entities.UserEntity;
import MSGUserService.models.errors.signup.SignUpError;
import MSGUserService.models.requests.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordHandler passwordHandler;

    @Autowired
    private DtoMapper dtoMapper;

    public Boolean signUp(SignUpRequest signUpRequest) {

        checkSignUpRequestValidity(signUpRequest);

        UserDto userDto = new UserDto();

        String passwordDigest = passwordHandler.hashNewPassword(signUpRequest.getPassword());
        long userCode = 1234;

        userDto.setUsername(signUpRequest.getUsername());
        userDto.setPasswordDigest(passwordDigest);
        userDto.setUserCode(userCode);
        userDto.setEmail(signUpRequest.getEmail());

        UserEntity userEntity = dtoMapper.convertToEntity(userDto);
        try {
            userDao.save(userEntity);
        } catch (Exception e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private void checkSignUpRequestValidity(SignUpRequest signUpRequest) {

    }

}
