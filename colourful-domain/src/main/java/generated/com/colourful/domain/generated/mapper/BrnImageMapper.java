package com.colourful.domain.generated.mapper;
import java.util.List;
import com.colourful.domain.generated.record.BrnImage;

public interface BrnImageMapper {
	List<BrnImage> getBrnImageList();
	int insert(BrnImage brnimage);
	BrnImage readByPk(BrnImage brnimage);
	int update(BrnImage brnimage);
	int delete(BrnImage brnimage);
}