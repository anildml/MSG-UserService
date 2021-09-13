package MSGUserService.models.errors.login;

import MSGUserService.models.errors.MsgException;

public abstract class LoginException extends MsgException {

    public LoginException(String message, Throwable cause, int errorCode) {
        super(message, cause, errorCode);
    }

    public LoginException(String message, int errorCode) {
        super(message, errorCode);
    }
}
