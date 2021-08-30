package MSGUserService.helpers;

import MSGUserService.models.dtos.UserDto;
import org.springframework.stereotype.Service;

public interface AuthHelper {

    String buildTokenForUser(UserDto userDto);

}

@Service
class AuthHelperImpl implements AuthHelper {

    @Override
    public String buildTokenForUser(UserDto userDto) {
        return null;
    }
}
