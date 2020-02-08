package login.service.backend.Responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import login.service.backend.Enum.LoginStatus;
import lombok.Data;

@Data
public class LoginResponse {

  @JsonProperty("status")
  private int status;

  @JsonProperty("message")
  private String message;

  public LoginResponse(LoginStatus status) {
    this.message = status.getMessage();
    this.status = status.getStatusCode();
  }
}
