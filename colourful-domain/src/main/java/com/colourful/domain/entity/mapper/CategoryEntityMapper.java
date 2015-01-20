package com.colourful.domain.entity.mapper;

import java.util.List;

import com.colourful.domain.data.CategoryDetail;
import com.colourful.domain.data.ProductDetail;

public interface CategoryEntityMapper {
	List<CategoryDetail> getAllCategories();

	List<ProductDetail> getAllProductsByCategoryId(long categoryId);

}
