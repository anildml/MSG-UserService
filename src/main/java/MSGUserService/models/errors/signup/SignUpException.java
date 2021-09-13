package MSGUserService.models.errors.signup;

import MSGUserService.models.errors.MsgException;

public abstract class SignUpException extends MsgException {

    public SignUpException(String message, Throwable cause, int errorCode) {
        super(message, cause, errorCode);
    }

    public SignUpException(String message, int errorCode) {
        super(message, errorCode);
    }

}
