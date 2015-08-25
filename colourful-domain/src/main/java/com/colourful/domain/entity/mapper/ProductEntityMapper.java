package com.colourful.domain.entity.mapper;

import java.util.List;

import com.colourful.domain.data.ProductDetail;
import com.colourful.domain.generated.record.BrnImage;

public interface ProductEntityMapper {

	List<BrnImage> getAllImages(long productId);

	public List<ProductDetail> getRecommendedProduct(int count);
}
