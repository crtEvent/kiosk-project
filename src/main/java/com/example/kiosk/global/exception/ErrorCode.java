package com.example.kiosk.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
	RESOURCE_NOT_FOUND(404, "해당 자원을 찾을 수 없습니다.");

	private final int statusCode;
	private final String description;
}
