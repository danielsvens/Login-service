package login.service.backend.Enum;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Role {
  @JsonProperty("admin") ADMIN,
  @JsonProperty("user") USER,
  @JsonProperty("developer") DEVELOPER
}
