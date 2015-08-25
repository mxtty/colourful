package com.colourful.domain.entity.mapper;

import java.util.List;

import com.colourful.domain.generated.record.BrnImage;

public interface ImageEntityMapper {

	List<BrnImage> getImageListById(int id);

}
