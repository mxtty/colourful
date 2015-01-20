package com.colourful.domain.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.colourful.domain.data.CategoryDetail;
import com.colourful.domain.data.Products;
import com.colourful.domain.entity.mapper.CategoryEntityMapper;
import com.colourful.domain.generated.base.BrnCategoryBase;

@Component
@Scope("prototype")
@SuppressWarnings("serial")
public class BrnCategoryEntity extends BrnCategoryBase implements Serializable {
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
