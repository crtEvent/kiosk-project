package com.example.kiosk.category.repository.port;

import java.util.List;

import com.example.kiosk.category.domain.Category;

public interface CategoryRepository {
	List<Category> findAll();
}
