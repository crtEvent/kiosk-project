package com.example.kiosk.category.service.port;

import java.util.List;

import com.example.kiosk.category.domain.Category;

public interface CategoryService {
	List<Category> getAll();
}
