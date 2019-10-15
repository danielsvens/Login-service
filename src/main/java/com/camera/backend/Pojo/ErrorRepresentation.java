package com.camera.backend.Pojo;


import com.camera.backend.Enum.ErrorStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
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
