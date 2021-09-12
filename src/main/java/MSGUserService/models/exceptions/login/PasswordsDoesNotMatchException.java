package MSGUserService.models.exceptions.login;

public class PasswordsDoesNotMatchException extends LoginException {

    private static final int errorCode = 0;
    private static final String errorMessage = "Passwords Does Not Match!";

    public PasswordsDoesNotMatchException() {
        super(errorMessage, errorCode);
    }

}
