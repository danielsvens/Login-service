package login.service.backend.Rest;

import login.service.backend.Pojo.Login;
import login.service.backend.Pojo.User;
import login.service.backend.Responses.LoginResponse;
import login.service.backend.Responses.UserCreatedResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/v1/service")
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
