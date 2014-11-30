package com.colourful.domain.generated.mapper;

import java.util.List;

import com.colourful.domain.entity.Category;

public interface CategoryMapper {

	List<Category> getCategoryList();

	Category getCategory(String categoryId);

}
