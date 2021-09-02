package MSGUserService.controllers;

import MSGUserService.helpers.ResponseBuilder;
import MSGUserService.models.requests.LoginRequest;
import MSGUserService.models.responses.core.AppError;
import MSGUserService.models.responses.core.BaseResponse;
import MSGUserService.models.responses.LoginResponse;
import MSGUserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResponseBuilder responseBuilder;

    @GetMapping("/login")
    public ResponseEntity<BaseResponse<LoginResponse>> login(@RequestBody LoginRequest loginRequest) {
        try {
            String token = userService.loginAndGetToken(loginRequest);
            LoginResponse loginResponse = new LoginResponse(token);
            return responseBuilder.SuccessfulResponse(loginResponse);
        } catch (Exception e) {
            return responseBuilder.ErrorResponse(AppError.GENERIC_ERROR);
        }
    }

}
