package MSGUserService.models.errors;

import lombok.Getter;

@Getter
public abstract class MsgError extends RuntimeException {

    /*
    MOVE AppError DEFINITIONS HERE
    DEFINE ERROR CODES AND ERROR MESSAGES AND REASONS HERE
     */

    private final int errorCode;

    public MsgError(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public MsgError(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
