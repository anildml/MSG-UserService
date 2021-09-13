package MSGUserService.models.errors.login;

public class PasswordsDoesNotMatchError extends LoginError {

    private static final int errorCode = 0;
    private static final String errorMessage = "Passwords Does Not Match!";

    public PasswordsDoesNotMatchError() {
        super(errorMessage, errorCode);
    }

}
