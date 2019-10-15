package com.camera.backend.Rest;

import com.camera.backend.Pojo.User;
import com.camera.backend.Responses.UserCreatedResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/cameraApp")
public interface CameraApiV1 {

    @PostMapping(value = "/register", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    ResponseEntity<UserCreatedResponse> register(@RequestBody User createUser);

    @GetMapping(value = "/user/{id}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    ResponseEntity<User> getUser(@PathVariable("id") long id);
}
