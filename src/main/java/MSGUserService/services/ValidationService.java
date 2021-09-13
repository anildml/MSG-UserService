package MSGUserService.services;

import MSGUserService.helpers.AuthHelper;
import MSGUserService.models.errors.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface ValidationService {

    Boolean validate(Long userCode, String token) throws ValidationException;

}

@Service
class ValidationServiceImpl implements ValidationService {

    @Autowired
    private AuthHelper authHelper;


    @Override
    public Boolean validate(Long userCode, String token) throws ValidationException {
        return authHelper.isTokenValid(userCode, token);
    }

}
