package com.example.kiosk.category.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.kiosk.category.controller.response.CategoryResponse;
import com.example.kiosk.category.service.port.CategoryService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api")
@Controller
@RequiredArgsConstructor
public class CategoryController {
	private final CategoryService categoryService;

	@GetMapping("/categories")
	public ResponseEntity<List<CategoryResponse>> getCategories() {
		return ResponseEntity
			.ok()
			.body(
				categoryService
					.getAll()
					.stream()
					.map(CategoryResponse::from)
					.toList()
			);
	}
}
