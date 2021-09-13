package MSGUserService.models.errors;

import lombok.Getter;

@Getter
public abstract class MsgException extends RuntimeException {

    /*
    MOVE AppError DEFINITIONS HERE
    DEFINE ERROR CODES AND ERROR MESSAGES AND REASONS HERE
     */

    private final int errorCode;

    public MsgException(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public MsgException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
