package com.camera.backend.Rest;


import com.camera.backend.Exceptions.UserNotFoundException;
import com.camera.backend.Service.UserService;
import com.camera.backend.Model.UserModel;
import com.camera.backend.Pojo.User;
import com.camera.backend.Responses.UserCreatedResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CameraApiV1Controller implements CameraApiV1 {

    private final UserService userService;

    @Autowired
    public CameraApiV1Controller(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserCreatedResponse> register(User user) {

        long createdUserId = userService.saveUser(user);
        log.info("Created user with id: {}", createdUserId);

        UserCreatedResponse createdResponse =
                UserCreatedResponse.builder()
                        .id(String.valueOf(createdUserId))
                        .message("User created")
                        .build();

        return new ResponseEntity<>(createdResponse, HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<User> getUser(long id) {

        log.info("Getting user by id: {}", id);
        final UserModel userModel = userService.findUser(id)
                .orElseThrow(() -> new UserNotFoundException("Could not find user with id: " + id));

        return new ResponseEntity<>(userModel.toPojo(), HttpStatus.OK);
    }
}
