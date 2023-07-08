package com.example.kiosk.category.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.kiosk.category.domain.Category;
import com.example.kiosk.category.service.port.CategoryService;
import com.example.kiosk.category.repository.port.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepository categoryRepository;

	public List<Category> getAll() {
		return categoryRepository.findAll();
	}
}
