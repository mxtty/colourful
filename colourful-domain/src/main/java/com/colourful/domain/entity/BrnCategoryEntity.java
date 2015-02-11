package com.colourful.domain.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.colourful.domain.data.CategoryDetail;
import com.colourful.domain.data.Products;
import com.colourful.domain.entity.mapper.CategoryEntityMapper;
import com.colourful.domain.generated.base.BrnCategoryBase;
import com.colourful.domain.stereotype.Entity;

@Entity
@SuppressWarnings("serial")
public class BrnCategoryEntity extends BrnCategoryBase {
	@Autowired
	private CategoryEntityMapper categoryEntityMapper;

	public List<CategoryDetail> getAllCategories() {
		return categoryEntityMapper.getAllCategories();
	}

	public Products getProducts() {
		super.getEntityByPk();
		Products products = new Products();
		products.setCategoryId(categoryId);
		products.setCategoryName(categoryName);
		products.addProduct(categoryEntityMapper.getAllProductsByCategoryId(categoryId));

		return products;

	}
}
