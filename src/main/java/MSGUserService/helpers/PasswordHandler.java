package MSGUserService.helpers;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

public interface PasswordHandler {

    String hashNewPassword(String password);

    Boolean doesPasswordsMatch(String storedPassword, String receivedPassword);

}

@Service
class PasswordHandlerImpl implements PasswordHandler {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String hashNewPassword(String password) {
        String randomSalt = RandomStringUtils.random(20, true, false);
        String digest = passwordEncoder.encode(buildSaltedRawPassword(password, randomSalt));
        return randomSalt + digest;
    }

    public Boolean doesPasswordsMatch(String storedPassword, String receivedPassword) {
        String salt = storedPassword.substring(0, 20);
        String storedPasswordDigest = storedPassword.substring(20);
        String saltedReceivedPassword = buildSaltedRawPassword(receivedPassword, salt);
        return passwordEncoder.matches(saltedReceivedPassword, storedPasswordDigest);
    }

    private String buildSaltedRawPassword(String password, String salt) {
        return salt + password;
    }

}
