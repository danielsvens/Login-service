package com.camera.backend.Advice;

import com.camera.backend.Enum.ErrorStatus;
import com.camera.backend.Exceptions.UserNotFoundException;
import com.camera.backend.Pojo.ErrorRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class UserNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorRepresentation> handle(UserNotFoundException e) {
        ErrorRepresentation error = ErrorRepresentation.builder()
                .errorStatus(ErrorStatus.RESOURCE_NOT_FOUND)
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
