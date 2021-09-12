package MSGUserService.models.responses.core;

import MSGUserService.models.exceptions.MsgException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AppError {

    private final int errorCode;
    private final String errorMessage;

    public AppError(MsgException msgException) {
        this.errorCode = msgException.getErrorCode();
        this.errorMessage = msgException.getMessage();
    }

}
