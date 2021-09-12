package MSGUserService.models.exceptions.signup;

import MSGUserService.models.exceptions.MsgException;

public abstract class SignUpException extends MsgException {

    public SignUpException(String message, Throwable cause, int errorCode) {
        super(message, cause, errorCode);
    }

}
