package MSGUserService.models.errors.validation;

import MSGUserService.models.errors.MsgException;

public class ValidationException extends MsgException {

    public ValidationException(String message, Throwable cause, int errorCode) {
        super(message, cause, errorCode);
    }

    public ValidationException(String message, int errorCode) {
        super(message, errorCode);
    }

}
