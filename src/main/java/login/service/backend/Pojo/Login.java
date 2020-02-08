package login.service.backend.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Login implements Serializable {

  @JsonProperty("userName")
  @NotNull
  private String userName;

  @JsonProperty("password")
  @NotNull
  private String password;
}
