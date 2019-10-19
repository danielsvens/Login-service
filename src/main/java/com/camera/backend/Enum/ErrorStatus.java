package com.camera.backend.Enum;

import lombok.Getter;

@Getter
public enum ErrorStatus {
    RESOURCE_NOT_FOUND(1, "Resource not found"),
    EMAIL_VALIDATION_FAILED(2, "Invalid email"),
    UNKNOWN_REASON(0, "Unknown error")
    ;

    private final int errorCode;
    private final String reason;

    ErrorStatus(int errorCode, String reason) {
        this.errorCode = errorCode;
        this.reason = reason;
    }
}
