package com.camera.backend.Advice;

import com.camera.backend.Enum.ErrorStatus;
import com.camera.backend.Pojo.ErrorRepresentation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class ConstraintAdvice {

    @ResponseBody
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorRepresentation> handle(DataIntegrityViolationException e) {

        String errorMsg = e.getRootCause().getMessage() != null ?
                findConstraint(e.getRootCause().getMessage()) : "Unknown error";

        return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorRepresentation.builder()
                .errorStatus(ErrorStatus.UNIQUE_CONSTRAINT_VIOLATION)
                .message(errorMsg)
                .build());
    }

    private String findConstraint(String errorMsg) {
        return errorMsg.contains("email") ? "Email already exist." : "User already exist.";
    }
}
