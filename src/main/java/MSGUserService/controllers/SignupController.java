package MSGUserService.controllers;

import MSGUserService.helpers.ResponseBuilder;
import MSGUserService.models.exceptions.signup.SignUpException;
import MSGUserService.models.requests.SignUpRequest;
import MSGUserService.models.responses.SignUpResponse;
import MSGUserService.models.responses.core.AppError;
import MSGUserService.models.responses.core.BaseResponse;
import MSGUserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResponseBuilder responseBuilder;

    @PostMapping()
    public ResponseEntity<BaseResponse<SignUpResponse>> signUp(@RequestBody SignUpRequest signUpRequest) {
        try {
            userService.signUp(signUpRequest);
            return responseBuilder.SuccessfulResponse(null);
        } catch (SignUpException e) {
            return responseBuilder.ErrorResponse(e);
        }
    }

}
