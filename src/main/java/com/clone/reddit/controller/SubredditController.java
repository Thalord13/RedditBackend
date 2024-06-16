package com.clone.reddit.controller;

import com.clone.reddit.model.Response;
import com.clone.reddit.service.implementation.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class SubredditController {

    private final UserServiceImpl userService;

    @GetMapping("/test")
    public String test() {
        return "THIS IS TEST";
    }

    @GetMapping("/api/register")
    public ResponseEntity<Response> getUsers() throws InterruptedException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("users", userService.list()))
                        .message("Users retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
