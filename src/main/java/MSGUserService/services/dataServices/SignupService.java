package MSGUserService.services.dataServices;

import MSGUserService.daos.UserDao;
import MSGUserService.services.helpers.PasswordHandler;
import MSGUserService.models.dtos.UserDto;
import MSGUserService.models.entities.UserEntity;
import MSGUserService.models.requests.SignUpRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SignupService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordHandler passwordHandler;

    @Autowired
    private ModelMapper mapper;

    public Boolean signUp(SignUpRequest signUpRequest) {

        checkSignUpRequestValidity(signUpRequest);

        UserDto userDto = new UserDto();

        String passwordDigest = passwordHandler.hashNewPassword(signUpRequest.getPassword());
        BigDecimal userCode = new BigDecimal(1234);

        userDto.setUsername(signUpRequest.getUsername());
        userDto.setPasswordDigest(passwordDigest);
        userDto.setUserCode(userCode);
        userDto.setEmail(signUpRequest.getEmail());

        UserEntity userEntity = mapper.map(userDto, UserEntity.class);
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
