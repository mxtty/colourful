package com.colourful.domain.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.colourful.domain.entity.mapper.NewsEntityMapper;
import com.colourful.domain.generated.base.BrnNewsBase;
import com.colourful.domain.generated.record.BrnNews;
import com.colourful.domain.stereotype.Entity;

@Entity
@SuppressWarnings("serial")
public class BrnNewsEntity extends BrnNewsBase {

	@Autowired
	private NewsEntityMapper newsEntityMapper;

	public List<BrnNews> readHomeNews() {
		return newsEntityMapper.readHomeNews();
	}
}
