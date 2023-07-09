package com.example.kiosk.menu.repository.jdbctemplate;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.kiosk.menu.domain.Menu;
import com.example.kiosk.menu.repository.jdbctemplate.entity.MenuEntity;
import com.example.kiosk.menu.repository.port.MenuRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MenuJdbcRepositoryImpl implements MenuRepository {
	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Optional<Menu> findById(int categoryId, int menuId) {
		String sql = "SELECT id, name, price, image_path, description, category_id "
			+ "FROM menu "
			+ "WHERE category_id = :categoryId AND id = :menuId";

		SqlParameterSource param = new MapSqlParameterSource()
			.addValue("categoryId", categoryId)
			.addValue("menuId", menuId);

		try {
			return Optional.ofNullable(
				jdbcTemplate.queryForObject(sql, param, getMenuRowMapper())
			).map(MenuEntity::toDomain);
		} catch (EmptyResultDataAccessException e) {
			return Optional.empty();
		}
	}

	@Override
	public List<Menu> findAllByCategoryId(int categoryId) {
		String sql = "SELECT id, name, price, image_path, description, category_id "
			+ "FROM menu "
			+ "WHERE category_id = :categoryId";

		SqlParameterSource param = new MapSqlParameterSource()
			.addValue("categoryId", categoryId);

		return jdbcTemplate.query(sql, param, getMenuRowMapper())
			.stream()
			.map(MenuEntity::toDomain)
			.toList();
	}

	private RowMapper<MenuEntity> getMenuRowMapper() {
		return (rs, rowNum) -> MenuEntity
			.builder()
			.id(rs.getInt("id"))
			.name(rs.getString("name"))
			.price(rs.getInt("price"))
			.imagePath(rs.getString("image_path"))
			.description(rs.getString("description"))
			.categoryId(rs.getInt("category_id"))
			.build();
	}
}
