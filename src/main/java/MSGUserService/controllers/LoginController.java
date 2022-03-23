package MSGUserService.controllers;

import MSGUserService.core.ResponseBuilder;
import MSGUserService.models.errors.login.LoginError;
import MSGUserService.models.requests.LoginRequest;
import MSGUserService.models.responses.LoginResponse;
import MSGUserService.models.responses.core.BaseResponse;
import MSGUserService.services.dataServices.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private ResponseBuilder responseBuilder;

    @GetMapping()
    public ResponseEntity<BaseResponse<LoginResponse>> login(@RequestBody LoginRequest loginRequest) {
        try {
            String token = loginService.loginAndGetToken(loginRequest);
            LoginResponse loginResponse = new LoginResponse(token);
            return responseBuilder.SuccessfulResponse(loginResponse);
        } catch (LoginError e) {
            return responseBuilder.ErrorResponse(e);
        }
    }

}
