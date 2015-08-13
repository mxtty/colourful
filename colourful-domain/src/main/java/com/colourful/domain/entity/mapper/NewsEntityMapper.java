package com.colourful.domain.entity.mapper;

import java.util.List;

import com.colourful.domain.generated.record.BrnNews;

public interface NewsEntityMapper {

	List<BrnNews> readHomeNews();

	List<BrnNews> getRecords(BrnNews brnNews);
}
