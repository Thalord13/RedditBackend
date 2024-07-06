package com.clone.reddit.controller;

import com.clone.reddit.model.Response;
import com.clone.reddit.service.implementation.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class ProfileController {

    private final UserServiceImpl userService;

    @GetMapping("/test")
    public String test() {
        return "THIS IS TEST";
    }

    @GetMapping("/api/v1/profile")
    public ResponseEntity<Response> profile() throws InterruptedException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .message("This is profile")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
