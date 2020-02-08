package login.service.backend.Enum;

import lombok.Getter;

@Getter
public enum ErrorStatus {
  UNKNOWN_REASON(0, "Unknown error"),
  RESOURCE_NOT_FOUND(1, "Resource not found"),
  EMAIL_VALIDATION_FAILED(2, "Invalid email"),
  UNIQUE_CONSTRAINT_VIOLATION(3, "Field already exists"),
  ;

  private final int errorCode;
  private final String reason;

  ErrorStatus(int errorCode, String reason) {
    this.errorCode = errorCode;
    this.reason = reason;
  }
}
