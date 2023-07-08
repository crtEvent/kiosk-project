package com.example.kiosk.menu.controller.response;

import com.example.kiosk.menu.domain.Menu;

import lombok.Builder;

@Builder
public record MenuResponse(
	int id,
	String name,
	int price,
	String imagePath,
	String description,
	int categoryId
) {
	public static MenuResponse from(Menu menu) {
		return MenuResponse
			.builder()
			.id(menu.id())
			.name(menu.name())
			.price(menu.price())
			.imagePath(menu.imagePath())
			.description(menu.description())
			.categoryId(menu.categoryId())
			.build();
	}
}
