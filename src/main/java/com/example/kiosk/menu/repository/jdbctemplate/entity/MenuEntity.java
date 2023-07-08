package com.example.kiosk.menu.repository.jdbctemplate.entity;

import com.example.kiosk.menu.domain.Menu;

import lombok.Builder;

@Builder
public record MenuEntity(
	int id,
	String name,
	int price,
	String imagePath,
	String description,
	int categoryId
) {
	public Menu toDomain() {
		return Menu.builder()
			.id(id)
			.name(name)
			.price(price)
			.imagePath(imagePath)
			.description(description)
			.categoryId(categoryId)
			.build();
	}
}
