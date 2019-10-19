package com.camera.backend.Responses;

import com.camera.backend.Enum.LoginStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
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
