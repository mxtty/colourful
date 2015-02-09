package com.colourful.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.colourful.domain.data.ProductDetail;
import com.colourful.domain.entity.BrnImageEntity;
import com.colourful.domain.entity.BrnProductEntity;
import com.colourful.domain.generated.record.BrnImage;
import com.colourful.domain.service.base.EntityFactory;

@Service
public class ProductService {

	public ProductDetail getProductDetail(long productId) {

		BrnProductEntity brnProductEntity = EntityFactory.newBrnProductEntity(productId);
		brnProductEntity.getEntityByPk();

		BrnImageEntity brnImageEntity = EntityFactory.newBrnImageEntity();
		brnImageEntity.setId(productId);

		List<BrnImage> imageList = brnImageEntity.getRecords();

		ProductDetail productDetail = new ProductDetail();

		brnProductEntity.toObject(productDetail);

		if (CollectionUtils.isEmpty(imageList)) {
			return productDetail;
		}

		productDetail.setImgFileMain(imageList.get(0).getImageFile());

		for (int i = 0; i < imageList.size() && i < 4; i++) {

			productDetail.addImgFileSub(imageList.get(i).getImageFile());
		}

		return productDetail;
	}

}
