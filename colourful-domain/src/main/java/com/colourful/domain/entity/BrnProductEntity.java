package com.colourful.domain.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.colourful.domain.entity.mapper.ProductEntityMapper;
import com.colourful.domain.generated.base.BrnProductBase;
import com.colourful.domain.generated.record.BrnImage;
import com.colourful.domain.stereotype.Entity;

@Entity
@SuppressWarnings("serial")
public class BrnProductEntity extends BrnProductBase {

	@Autowired
	private ProductEntityMapper productEntityMapper;

	public List<BrnImage> getAllImages() {
		checkPkNotNull();
		return productEntityMapper.getAllImages(productId);
	}

}
