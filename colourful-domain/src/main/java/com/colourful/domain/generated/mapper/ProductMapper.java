package com.colourful.domain.generated.mapper;

import java.util.List;

import com.colourful.domain.entity.Product;

public interface ProductMapper {

	List<Product> getProductListByCategory(String categoryId);

	Product getProduct(String productId);

	List<Product> searchProductList(String keywords);

}
