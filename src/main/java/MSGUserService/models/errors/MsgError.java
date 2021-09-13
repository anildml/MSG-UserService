package MSGUserService.models.errors;

import lombok.Getter;

@Getter
public abstract class MsgError extends RuntimeException {

    /**
     * LOGIN ERRORS
     *      0-0     Invalid Password
     *      0-1     Invalid Username
     *
     *  SIGN UP ERRORS
     *      1-0     Invalid Email
     *      1-1     Invalid Password
     *      1-2     Invalid Username
     *
     *  VALIDATION ERRORS
     *      2-0     Invalid User Code
     *      2-1     Token Not Valid
     */

    private final String errorCode;

    public MsgError(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public MsgError(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
