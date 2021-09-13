package MSGUserService.controllers;

import MSGUserService.helpers.ResponseBuilder;
import MSGUserService.models.errors.signup.SignUpException;
import MSGUserService.models.requests.SignUpRequest;
import MSGUserService.models.responses.SignUpResponse;
import MSGUserService.models.responses.core.BaseResponse;
import MSGUserService.services.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private SignupService signupService;

    @Autowired
    private ResponseBuilder responseBuilder;

    @PostMapping()
    public ResponseEntity<BaseResponse<SignUpResponse>> signUp(@RequestBody SignUpRequest signUpRequest) {
        try {
            Boolean successful = signupService.signUp(signUpRequest);
            SignUpResponse signUpResponse = new SignUpResponse(successful);
            return responseBuilder.SuccessfulResponse(signUpResponse);
        } catch (SignUpException e) {
            return responseBuilder.ErrorResponse(e);
        }
    }

}
