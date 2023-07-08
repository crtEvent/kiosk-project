package com.example.kiosk.menu.domain;

import lombok.Builder;

@Builder
public record Menu(
	int id,
	String name,
	int price,
	String imagePath,
	String description,
	int categoryId
) {
}
