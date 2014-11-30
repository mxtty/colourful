package com.colourful.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colourful.domain.entity.Category;
import com.colourful.domain.entity.Product;
import com.colourful.domain.generated.mapper.CategoryMapper;
import com.colourful.domain.generated.mapper.ItemMapper;
import com.colourful.domain.generated.mapper.ProductMapper;
import com.colourful.domain.record.Item;

@Service
public class CatalogService {

	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ProductMapper productMapper;

	public List<Category> getCategoryList() {
		return categoryMapper.getCategoryList();
	}

	public Category getCategory(String categoryId) {
		return categoryMapper.getCategory(categoryId);
	}

	public Product getProduct(String productId) {
		return productMapper.getProduct(productId);
	}

	public List<Product> getProductListByCategory(String categoryId) {
		return productMapper.getProductListByCategory(categoryId);
	}

	// TODO enable using more than one keyword
	public List<Product> searchProductList(String keyword) {
		return productMapper.searchProductList("%" + keyword.toLowerCase()
				+ "%");
	}

	public List<Item> getItemListByProduct(String productId) {
		return itemMapper.getItemListByProduct(productId);
	}

	public Item getItem(String itemId) {
		return itemMapper.getItem(itemId);
	}

	public boolean isItemInStock(String itemId) {
		return itemMapper.getInventoryQuantity(itemId) > 0;
	}
}