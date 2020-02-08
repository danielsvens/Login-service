package login.service.backend.Enum;

import lombok.Getter;

@Getter
public enum LoginStatus {
  FAILED(1, "Login failed."),
  SUCCESS(2, "Login was successful.");

  private final int statusCode;
  private final String message;

  LoginStatus(int statusCode, String message) {
    this.statusCode = statusCode;
    this.message = message;
  }
}