package MSGUserService.models.errors.validation;

public class TokenNotValidError extends ValidationError {

    private static final String errorCode = "2-0";
    private static final String errorMessage = "Can't Authenticate!";

    public TokenNotValidError() {
        super(errorMessage, errorCode);
    }

}
