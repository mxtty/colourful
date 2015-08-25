package com.colourful.domain.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.colourful.domain.entity.mapper.ImageEntityMapper;
import com.colourful.domain.generated.base.BrnImageBase;
import com.colourful.domain.generated.record.BrnImage;
import com.colourful.domain.stereotype.Entity;

@Entity
@SuppressWarnings("serial")
public class BrnImageEntity extends BrnImageBase {

	@Autowired
	private ImageEntityMapper imageEntityMapper;

	private final static int HOME_IMAGE_ID = 200;

	public List<BrnImage> getHomeImageList() {

		List<BrnImage> homeImageList = imageEntityMapper.getImageListById(HOME_IMAGE_ID);
		return homeImageList;
	}

}
