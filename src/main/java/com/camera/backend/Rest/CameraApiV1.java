package com.camera.backend.Rest;

import com.camera.backend.Pojo.Login;
import com.camera.backend.Pojo.User;
import com.camera.backend.Responses.LoginResponse;
import com.camera.backend.Responses.UserCreatedResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/v1/cameraApp")
public interface CameraApiV1 {

    @PostMapping(value = "/register", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    ResponseEntity<UserCreatedResponse> register(@RequestBody @Valid User createUser);

    @GetMapping(value = "/user/{id}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    ResponseEntity<User> getUser(@PathVariable("id") long id);

    @PostMapping(value = "/login", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    ResponseEntity<LoginResponse> login(@RequestBody @Valid Login loginUser);
}
