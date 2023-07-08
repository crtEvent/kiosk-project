package com.example.kiosk.category.controller.response;

import com.example.kiosk.category.domain.Category;

public record CategoryResponse(
	int id,
	String name
) {
	public static CategoryResponse from(Category category) {
		return new CategoryResponse(
			category.id(),
			category.name()
		);
	}
}
