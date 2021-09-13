package MSGUserService.models.errors.signup;

public class InvalidPasswordError extends SignUpError {

    private static final String errorCode = "1-1";
    private static final String errorMessage = "Invalid Password!";

    public InvalidPasswordError() {
        super(errorMessage, errorCode);
    }

}
