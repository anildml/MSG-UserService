package MSGUserService.models.errors.signup;

public class InvalidEmailError extends SignUpError {

    private static final String errorCode = "1-0";
    private static final String errorMessage = "Invalid Email!";

    public InvalidEmailError() {
        super(errorMessage, errorCode);
    }

}
