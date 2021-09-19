package MSGUserService.models.responses.core;

import MSGUserService.models.errors.MsgError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AppError {

    private final String errorCode;
    private final String errorMessage;

    public AppError(MsgError msgError) {
        this.errorCode = msgError.getErrorCode();
        this.errorMessage = msgError.getMessage();
    }

}
