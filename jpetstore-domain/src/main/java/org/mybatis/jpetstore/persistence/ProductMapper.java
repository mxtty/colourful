package org.mybatis.jpetstore.persistence;

import java.util.List;

import org.mybatis.jpetstore.domain.entity.Product;

public interface ProductMapper {

	List<Product> getProductListByCategory(String categoryId);

	Product getProduct(String productId);

	List<Product> searchProductList(String keywords);

}
