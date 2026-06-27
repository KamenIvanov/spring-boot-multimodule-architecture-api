package com.pe.multimodule.dto;

import java.io.Serializable;

public enum ErrorCodeDto implements Serializable {
    NOT_FOUND,
    CONFLICT,
    BAD_GATEWAY,
    BAD_REQUEST,
    UNAUTHORIZED,
    INTERNAL_ERROR,
    FORBIDDEN,
    SERVICE_UNAVAILABLE;

    public static ErrorCodeDto resolve(int statusCode) {
        return switch (statusCode) {
            case 400 -> ErrorCodeDto.BAD_REQUEST;
            case 401 -> ErrorCodeDto.UNAUTHORIZED;
            case 403 -> ErrorCodeDto.FORBIDDEN;
            case 404 -> ErrorCodeDto.NOT_FOUND;
            case 409 -> ErrorCodeDto.CONFLICT;
            case 502 -> ErrorCodeDto.BAD_GATEWAY;
            case 503 -> ErrorCodeDto.SERVICE_UNAVAILABLE;
            default -> ErrorCodeDto.INTERNAL_ERROR;
        };
    }
}
