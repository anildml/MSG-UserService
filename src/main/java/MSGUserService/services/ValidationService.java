package MSGUserService.services;

import MSGUserService.daos.UserDao;
import MSGUserService.helpers.AuthHelper;
import MSGUserService.helpers.DtoMapper;
import MSGUserService.models.dtos.UserDto;
import MSGUserService.models.errors.validation.TokenNotValidError;
import MSGUserService.models.errors.validation.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface ValidationService {

    String validateAndCreateNewToken(Long userCode, String token) throws ValidationError;

}

@Service
class ValidationServiceImpl implements ValidationService {

    @Autowired
    private AuthHelper authHelper;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DtoMapper dtoMapper;


    @Override
    public String validateAndCreateNewToken(Long userCode, String token) throws ValidationError {
        Boolean isTokenValid = authHelper.isTokenValid(userCode, token);
        if (!isTokenValid) {
            throw new TokenNotValidError();
        }
        UserDto userDto = dtoMapper.convertToUserDto(userDao.findUserEntityByUserCode(userCode));
        return authHelper.buildTokenForUser(userDto);
    }

}
