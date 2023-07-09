package com.example.kiosk.menu.repository.port;

import java.util.List;
import java.util.Optional;

import com.example.kiosk.menu.domain.Menu;

public interface MenuRepository {
	Optional<Menu> findById(int categoryId, int menuId);
	List<Menu> findAllByCategoryId(int categoryId);
}
