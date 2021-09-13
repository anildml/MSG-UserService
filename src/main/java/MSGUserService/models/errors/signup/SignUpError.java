package MSGUserService.models.errors.signup;

import MSGUserService.models.errors.MsgError;

public abstract class SignUpError extends MsgError {

    public SignUpError(String message, Throwable cause, int errorCode) {
        super(message, cause, errorCode);
    }

    public SignUpError(String message, int errorCode) {
        super(message, errorCode);
    }

}
