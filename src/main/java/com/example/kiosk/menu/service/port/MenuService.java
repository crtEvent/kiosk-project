package com.example.kiosk.menu.service.port;

import java.util.List;

import com.example.kiosk.menu.domain.Menu;

public interface MenuService {
	List<Menu> getAllByCategoryId(int categoryId);
}
