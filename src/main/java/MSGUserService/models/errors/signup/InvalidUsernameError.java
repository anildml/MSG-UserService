package MSGUserService.models.errors.signup;

public class InvalidUsernameError extends SignUpError {

    private static final String errorCode = "1-2";
    private static final String errorMessage = "Invalid Username!";

    public InvalidUsernameError() {
        super(errorMessage, errorCode);
    }

}
