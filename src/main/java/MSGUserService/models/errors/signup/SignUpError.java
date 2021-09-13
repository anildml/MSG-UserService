package MSGUserService.models.errors.signup;

import MSGUserService.models.errors.MsgError;

public abstract class SignUpError extends MsgError {

    public SignUpError(String message, Throwable cause, String errorCode) {
        super(message, cause, errorCode);
    }

    public SignUpError(String message, String errorCode) {
        super(message, errorCode);
    }

}
