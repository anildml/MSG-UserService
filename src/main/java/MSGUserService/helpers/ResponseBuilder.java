package MSGUserService.helpers;

import MSGUserService.models.errors.MsgError;
import MSGUserService.models.responses.core.AppError;
import MSGUserService.models.responses.core.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface ResponseBuilder {

    <T> ResponseEntity<BaseResponse<T>> SuccessfulResponse(T data);

    <T> ResponseEntity<BaseResponse<T>> ErrorResponse(MsgError msgError);

}

@Service
class ResponseBuilderImpl implements ResponseBuilder {

    public <T> ResponseEntity<BaseResponse<T>> SuccessfulResponse(T data) {
        return new ResponseEntity<>(new BaseResponse<>(true, null, data), HttpStatus.OK);
    }

    public <T> ResponseEntity<BaseResponse<T>> ErrorResponse(MsgError msgError) {
        AppError error = new AppError(msgError);
        return new ResponseEntity<>(new BaseResponse<>(false, error, null), HttpStatus.BAD_REQUEST);
    }

}
