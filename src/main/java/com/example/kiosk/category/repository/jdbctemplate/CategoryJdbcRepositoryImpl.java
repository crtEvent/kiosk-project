package com.example.kiosk.category.repository.jdbctemplate;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.kiosk.category.domain.Category;
import com.example.kiosk.category.repository.jdbctemplate.entity.CategoryEntity;
import com.example.kiosk.category.repository.port.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CategoryJdbcRepositoryImpl implements CategoryRepository  {
	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Category> findAll() {
		String sql = "SELECT id, name FROM category";

		try {
			return jdbcTemplate.query(sql, categoryRowMapper())
				.stream()
				.map(CategoryEntity::toDomain)
				.toList();
		} catch (DataAccessException e) {
			return List.of();
		}
	}

	private RowMapper<CategoryEntity> categoryRowMapper() {
		return (rs, rowNum) ->
			new CategoryEntity(
				rs.getInt("id"),
				rs.getString("name")
			);
	}

}
