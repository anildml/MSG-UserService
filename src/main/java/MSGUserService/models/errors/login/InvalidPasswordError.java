package MSGUserService.models.errors.login;

public class InvalidPasswordError extends LoginError {

    private static final String errorCode = "0-0";
    private static final String errorMessage = "Username and Password Does Not Match!";

    public InvalidPasswordError() {
        super(errorMessage, errorCode);
    }

}
