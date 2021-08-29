package MSGUserService.helpers;

import MSGUserService.models.dtos.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthHelper {

    String buildTokenForUser(UserDto userDto);

}

class AuthHelperImpl implements AuthHelper {

    @Override
    public String buildTokenForUser(UserDto userDto) {
        return null;
    }
}
