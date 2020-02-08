package login.service.backend.Advice;

import login.service.backend.Enum.ErrorStatus;
import login.service.backend.Exceptions.UserNotFoundException;
import login.service.backend.Pojo.ErrorRepresentation;
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
            .message(ErrorStatus.RESOURCE_NOT_FOUND.getReason())
            .build();

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }
}
