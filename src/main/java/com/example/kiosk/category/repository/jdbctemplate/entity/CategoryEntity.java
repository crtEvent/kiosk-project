package com.example.kiosk.category.repository.jdbctemplate.entity;

import com.example.kiosk.category.domain.Category;

public record CategoryEntity(
	int id,
	String name
) {
	public Category toDomain() {
		return new Category(id, name);
	}
}
