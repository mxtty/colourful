package com.colourful.domain.generated.mapper;
import java.util.List;
import com.colourful.domain.generated.record.BrnNews;

public interface BrnNewsMapper {
	List<BrnNews> getBrnNewsList();
	int insert(BrnNews brnnews);
	BrnNews readByPk(BrnNews brnnews);
	int update(BrnNews brnnews);
	int delete(BrnNews brnnews);
}