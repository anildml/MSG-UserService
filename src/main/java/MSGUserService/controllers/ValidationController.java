package MSGUserService.controllers;

import MSGUserService.core.ResponseBuilder;
import MSGUserService.models.errors.validation.ValidationError;
import MSGUserService.models.requests.ValidationRequest;
import MSGUserService.models.responses.ValidationResponse;
import MSGUserService.models.responses.core.BaseResponse;
import MSGUserService.services.dataServices.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validation")
public class ValidationController {

    @Autowired
    private ValidationService validationService;

    @Autowired
    private ResponseBuilder responseBuilder;

    @GetMapping("/validate")
    public ResponseEntity<BaseResponse<ValidationResponse>> login(@RequestBody ValidationRequest validationRequest) {
        try {
            String renewedToken = validationService.validateAndCreateNewToken(validationRequest.getUserCode(), validationRequest.getToken());
            ValidationResponse validationResponse = new ValidationResponse(true, renewedToken);
            return responseBuilder.SuccessfulResponse(validationResponse);
        } catch (ValidationError e) {
            return responseBuilder.ErrorResponse(e);
        }
    }

}
