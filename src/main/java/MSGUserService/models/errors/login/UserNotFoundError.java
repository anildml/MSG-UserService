package MSGUserService.models.errors.login;

public class UserNotFoundError extends LoginError {

    private static final int errorCode = 0;
    private static final String errorMessage = "User Not Found!";

    public UserNotFoundError() {
        super(errorMessage, errorCode);
    }

}
