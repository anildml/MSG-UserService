package MSGUserService.models.responses.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AppError {

    GENERIC_ERROR(0, "");

    private final int id;
    private final String error;

}
