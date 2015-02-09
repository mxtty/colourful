package com.colourful.domain.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.colourful.domain.entity.mapper.ProductEntityMapper;
import com.colourful.domain.generated.base.BrnProductBase;
import com.colourful.domain.generated.record.BrnImage;

@Component
@Scope("prototype")
@SuppressWarnings("serial")
public class BrnProductEntity extends BrnProductBase implements Serializable {

	@Autowired
	private ProductEntityMapper productEntityMapper;

	public List<BrnImage> getAllImages() {
		checkPkNotNull();
		return productEntityMapper.getAllImages(productId);
	}

}
