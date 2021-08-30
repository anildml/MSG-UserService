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
        // CREATE RANDOM STRING 20 CHAR LONG
        String salt = buildRandomSalt();

        // SPLIT IT RANDOMLY TO 2
        int splitIdx = (int)(Math.random() * 20);

        // HASH RAND[0] + PASSWORD + RAND[1]
        String digest = buildDigest(password, salt, splitIdx);

        // RETURN RAND + DIGEST
        return salt + digest;
    }

    public Boolean doesPasswordsMatch(String storedPassword, String receivedPassword) {
        String salt = storedPassword.substring(0, 20);
        String storedPasswordDigest = storedPassword.substring(20);
        for (int i = 0; i < 20; i++) {
            String digest = buildDigest(receivedPassword, salt, i);
            if (storedPasswordDigest.equals(digest)) {
                return true;
            }
        }
        return false;
    }

    private String buildRandomSalt() {
        return RandomStringUtils.random(20, true, false);
    }

    private String buildDigest(String password, String salt, int splitIdx) {
        return passwordEncoder.encode(
                salt.substring(0, splitIdx) +
                        password +
                        salt.substring(splitIdx, 20)
        );
    }

}
