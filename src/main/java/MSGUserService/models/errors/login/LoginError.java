package MSGUserService.models.errors.login;

import MSGUserService.models.errors.MsgError;

public abstract class LoginError extends MsgError {

    public LoginError(String message, Throwable cause, String errorCode) {
        super(message, cause, errorCode);
    }

    public LoginError(String message, String errorCode) {
        super(message, errorCode);
    }
}
