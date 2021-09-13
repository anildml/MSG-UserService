package MSGUserService.models.errors.validation;

public class InvalidUserCodeError extends ValidationError {

    private static final String errorCode = "2-0";
    private static final String errorMessage = "Invalid User Code!";

    public InvalidUserCodeError() {
        super(errorMessage, errorCode);
    }

}
