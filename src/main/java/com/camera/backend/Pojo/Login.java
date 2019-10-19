package com.camera.backend.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Login implements Serializable {

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;
}
