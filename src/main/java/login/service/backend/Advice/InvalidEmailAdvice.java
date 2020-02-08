package login.service.backend.Advice;

import login.service.backend.Enum.ErrorStatus;
import login.service.backend.Pojo.ErrorRepresentation;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.List;

@ControllerAdvice
public class InvalidEmailAdvice {

  @ResponseBody
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorRepresentation> handle(List<ConstraintViolationImpl> constraintViolations) {
    Path violation = constraintViolations.stream()
            .map(ConstraintViolationImpl::getPropertyPath)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Constraint Violation not found"));

    if ("email".equalsIgnoreCase(violation.toString())) {
      ErrorRepresentation error = ErrorRepresentation.builder()
              .errorStatus(ErrorStatus.EMAIL_VALIDATION_FAILED)
              .message(ErrorStatus.EMAIL_VALIDATION_FAILED.getReason())
              .build();

      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    ErrorRepresentation error = ErrorRepresentation.builder()
            .errorStatus(ErrorStatus.UNKNOWN_REASON)
            .message(ErrorStatus.UNKNOWN_REASON.getReason())
            .build();

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }
}
