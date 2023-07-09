package com.example.kiosk.global.exception;

public record ErrorResponse(
		ErrorCode errorCode,
		String message
) {
}
