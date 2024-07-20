package com.clone.reddit.auth;

import com.clone.reddit.model.AuthenticateRequest;
import com.clone.reddit.model.AuthenticationResponse;
import com.clone.reddit.model.Response;
import com.clone.reddit.model.UserAccount;
import com.clone.reddit.service.implementation.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody UserAccount request)
    {

        AuthenticationResponse authenticationResponse = userService.register(request);

        if(authenticationResponse.getIsExist())
        {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Response.builder()
                            .timeStamp(now())
                            .message("User account is already exist")
                            .status(CONFLICT)
                            .statusCode(CONFLICT.value())
                            .build()
            );
        } else {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(Map.of("User", authenticationResponse))
                            .message("User account created")
                            .status(CREATED)
                            .statusCode(CREATED.value())
                            .build()
            );
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody AuthenticateRequest request)
    {

        AuthenticationResponse authenticationResponse = userService.authenticate(request);

        if(!authenticationResponse.getIsExist())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Response.builder()
                            .timeStamp(now())
                            .message("Login Error")
                            .status(NOT_FOUND)
                            .statusCode(NOT_FOUND.value())
                            .build()
                    );
        } else
        {
            return ResponseEntity.ok(
                    Response.builder()
                            .timeStamp(now())
                            .data(Map.of("User", authenticationResponse))
                            .message("Login is successful")
                            .status(CREATED)
                            .statusCode(OK.value())
                            .build()
            );
        }
    }

}
