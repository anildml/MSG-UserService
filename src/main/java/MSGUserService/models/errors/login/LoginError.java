package MSGUserService.models.errors.login;

import MSGUserService.models.errors.MsgError;

public abstract class LoginError extends MsgError {

    public LoginError(String message, Throwable cause, int errorCode) {
        super(message, cause, errorCode);
    }

    public LoginError(String message, int errorCode) {
        super(message, errorCode);
    }
}
