package com.example.kiosk.menu.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kiosk.menu.controller.response.MenuResponse;
import com.example.kiosk.menu.service.port.MenuService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/categories/{categoryId}/menus")
@RestController
@RequiredArgsConstructor
public class MenuController {
	private final MenuService menuService;

	@GetMapping
	public ResponseEntity<List<MenuResponse>> getMenusByCategoryId(@PathVariable int categoryId) {
		return ResponseEntity.ok().body(
			menuService.getAllByCategoryId(categoryId)
				.stream()
				.map(MenuResponse::from)
				.toList()
		);
	}

	@GetMapping("/{menuId}")
	public ResponseEntity<MenuResponse> getMenuByMenuId(@PathVariable int categoryId, @PathVariable int menuId) {
		return ResponseEntity.ok().body(
			MenuResponse.from(menuService.getMenuById(categoryId, menuId))
		);
	}
}
