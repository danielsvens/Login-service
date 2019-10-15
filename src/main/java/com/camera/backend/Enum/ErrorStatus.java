package com.camera.backend.Enum;

import lombok.Getter;

@Getter
public enum ErrorStatus {
    RESOURCE_NOT_FOUND(60, "Resource not found");

    private final int errorCode;
    private final String reason;

    ErrorStatus(int errorCode, String reason) {
        this.errorCode = errorCode;
        this.reason = reason;
    }
}
