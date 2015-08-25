package com.colourful.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.colourful.domain.data.HomeContents;
import com.colourful.domain.entity.BrnImageEntity;
import com.colourful.domain.entity.BrnNewsEntity;
import com.colourful.domain.entity.BrnProductEntity;
import com.colourful.domain.generated.record.BrnImage;
import com.colourful.domain.generated.record.BrnNews;
import com.colourful.domain.service.base.EntityFactory;

@Service
public class HomeService {

	public HomeContents getHomeContents() {

		BrnNewsEntity brnNewsEntity = EntityFactory.newEntity(BrnNewsEntity.class);
		List<BrnNews> newsList = brnNewsEntity.readHomeNews();

		HomeContents homeContents = new HomeContents();

		BrnImageEntity imageEntity = EntityFactory.newBrnImageEntity();
		List<BrnImage> homeImageList = imageEntity.getHomeImageList();
		// TODO 暂定
		if (!CollectionUtils.isEmpty(homeImageList) && 1 < homeImageList.size()) {
			homeContents.setSliderFile(homeImageList.get(0).getImageFile());
			homeContents.setHomeSubImgFile(homeImageList.get(1).getImageFile());
		}
		// TODO：默认将第一个新闻作为简讯
		homeContents.setNewsletter(newsList.get(0));
		newsList.remove(0);
		// 其他新闻作为最新消息
		homeContents.addNews(newsList);

		// 获取推荐菜单
		BrnProductEntity productEntity = EntityFactory.newEntity(BrnProductEntity.class);
		// TODO：暂定推荐4条菜单
		homeContents.addProductList(productEntity.getRecommendedProduct(4));

		return homeContents;

	}
}
