package MSGUserService.services.dataServices;

import MSGUserService.daos.UserDao;
import MSGUserService.services.helpers.AuthHelper;
import MSGUserService.models.dtos.UserDto;
import MSGUserService.models.errors.validation.TokenNotValidError;
import MSGUserService.models.errors.validation.ValidationError;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ValidationService {

    @Autowired
    private AuthHelper authHelper;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ModelMapper mapper;

    public String validateAndCreateNewToken(BigDecimal userCode, String token) throws ValidationError {
        Boolean isTokenValid = authHelper.isTokenValid(userCode, token);
        if (!isTokenValid) {
            throw new TokenNotValidError();
        }
        UserDto userDto = mapper.map(userDao.findUserEntityByUserCode(userCode), UserDto.class);
        return authHelper.buildTokenForUser(userDto);
    }

}
