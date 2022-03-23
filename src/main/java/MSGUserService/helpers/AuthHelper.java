package MSGUserService.helpers;

import MSGUserService.models.dtos.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultJwtBuilder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Service
public class AuthHelper {

    private final String secret = "test";

    private final int validityDuration = 3; // 3 minutes

    public Boolean isTokenValid(BigDecimal userCode, String token) {
        Long userCodeFromToken = getUserCodeFromToken(token);
        if (!userCodeFromToken.equals(userCode.longValue())) {
            return Boolean.FALSE;
        }
        Boolean isTokenExpired = (new Date()).after(getExpirationDateFromToken(token));
        if (isTokenExpired) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public String buildTokenForUser(UserDto userDto) {
        JwtBuilder jwtBuilder = new DefaultJwtBuilder();

        Date expirationDate = buildExpirationDate();
        Date issuedAt = new Date();
        Long userCode = userDto.getUserCode();

        jwtBuilder
                .setExpiration(expirationDate)
                .setIssuedAt(issuedAt)
                .setSubject(String.valueOf(userCode))
                .signWith(SignatureAlgorithm.HS512, secret);

        return jwtBuilder.compact();
    }

    private Long getUserCodeFromToken(String token) {
        Claims claims = getAllClaimsFromToken(token);
        return Long.parseLong(claims.getSubject());
    }

    private Date buildExpirationDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, validityDuration);
        return calendar.getTime();
    }

    private Date getExpirationDateFromToken(String token) {
        return getAllClaimsFromToken(token).getExpiration();
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

}
