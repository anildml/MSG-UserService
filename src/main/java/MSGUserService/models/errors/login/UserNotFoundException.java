package MSGUserService.models.errors.login;

public class UserNotFoundException extends LoginException {

    private static final int errorCode = 0;
    private static final String errorMessage = "User Not Found!";

    public UserNotFoundException() {
        super(errorMessage, errorCode);
    }

}
