package login.service.backend.Responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreatedResponse {

  @NotNull
  @JsonProperty("id")
  private String id;

  @JsonProperty("message")
  private String message;
}
