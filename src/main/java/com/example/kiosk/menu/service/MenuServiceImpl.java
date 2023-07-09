package com.example.kiosk.menu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.kiosk.global.exception.BusinessException;
import com.example.kiosk.global.exception.ErrorCode;
import com.example.kiosk.menu.domain.Menu;
import com.example.kiosk.menu.repository.port.MenuRepository;
import com.example.kiosk.menu.service.port.MenuService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
	private final MenuRepository menuRepository;

	@Override
	public Menu getMenuById(int categoryId, int menuId) {
		return menuRepository.findById(categoryId, menuId).orElseThrow(
			() -> new BusinessException(ErrorCode.RESOURCE_NOT_FOUND)
		);
	}

	@Override
	public List<Menu> getAllByCategoryId(int categoryId) {
		return menuRepository.findAllByCategoryId(categoryId);
	}
}
