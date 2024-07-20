package com.clone.reddit.controller;

import com.clone.reddit.dto.SubredditDTO;
import com.clone.reddit.model.AuthenticationResponse;
import com.clone.reddit.model.Response;
import com.clone.reddit.service.implementation.SubredditServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class SubredditController {

    private final SubredditServiceImpl subredditService;

    @PostMapping("/create/subreddit")
    public ResponseEntity<Response> subreddit(@RequestHeader("Authorization") String authorizationHeader, @RequestBody SubredditDTO request)
    {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("Subreddit", subredditService.create(authorizationHeader, request)))
                        .message("Subreddit successfuly created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

}
