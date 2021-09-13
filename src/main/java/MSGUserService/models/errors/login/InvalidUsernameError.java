package MSGUserService.models.errors.login;

public class InvalidUsernameError extends LoginError {

    private static final String errorCode = "0-1";
    private static final String errorMessage = "Invalid Username!";

    public InvalidUsernameError() {
        super(errorMessage, errorCode);
    }

}
