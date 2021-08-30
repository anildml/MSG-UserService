package MSGUserService.helpers;

import MSGUserService.models.dtos.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

public interface AuthHelper {

    String getUsernameFromToken(String token);

    String buildTokenForUser(UserDto userDto);

}

@Service
class AuthHelperImpl implements AuthHelper {

    private final String secret = "test";

    @Override
    public String getUsernameFromToken(String token) {
        Claims claims = getAllClaimsFromToken(token);
        return claims.getSubject();
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    @Override
    public String buildTokenForUser(UserDto userDto) {
        return null;
    }
}
