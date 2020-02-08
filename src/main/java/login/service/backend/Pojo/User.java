package login.service.backend.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class User implements Serializable {

  @JsonIgnore
  private Long id;

  @NotNull
  @JsonProperty("userName")
  private String userName;

  @NotNull
  @JsonProperty("password")
  private String password;

  @NotNull
  @JsonProperty("userDetails")
  private UserDetail userDetails;
}
