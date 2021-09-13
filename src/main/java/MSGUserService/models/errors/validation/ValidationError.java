package MSGUserService.models.errors.validation;

import MSGUserService.models.errors.MsgError;

public abstract class ValidationError extends MsgError {

    public ValidationError(String message, Throwable cause, String errorCode) {
        super(message, cause, errorCode);
    }

    public ValidationError(String message, String errorCode) {
        super(message, errorCode);
    }

}
