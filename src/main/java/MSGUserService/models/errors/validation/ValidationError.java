package MSGUserService.models.errors.validation;

import MSGUserService.models.errors.MsgError;

public abstract class ValidationError extends MsgError {

    public ValidationError(String message, Throwable cause, int errorCode) {
        super(message, cause, errorCode);
    }

    public ValidationError(String message, int errorCode) {
        super(message, errorCode);
    }

}
