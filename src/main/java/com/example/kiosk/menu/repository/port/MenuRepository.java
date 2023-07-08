package com.example.kiosk.menu.repository.port;

import java.util.List;

import com.example.kiosk.menu.domain.Menu;

public interface MenuRepository {
	List<Menu> findAllByCategoryId(int categoryId);
}
