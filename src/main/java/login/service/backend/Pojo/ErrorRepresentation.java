package login.service.backend.Pojo;


import com.fasterxml.jackson.annotation.JsonProperty;
import login.service.backend.Enum.ErrorStatus;
import lombok.*;


@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ErrorRepresentation {

  @JsonProperty("errorStatus")
  private ErrorStatus errorStatus;

  @JsonProperty("message")
  private String message;


}
