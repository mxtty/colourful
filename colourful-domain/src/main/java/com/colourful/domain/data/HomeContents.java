package com.colourful.domain.data;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class HomeContents {

	/** 首页主图 */
	private String sliderFile;

	/** 首页辅图 */
	private String homeSubImgFile;

	/** 简讯 */
	private News newsletter;

	/** 新闻 */
	private List<News> newsList = new ArrayList<News>();

	private List<ProductDetail> productDetailList = new ArrayList<ProductDetail>();

	public void addNews(News news) {
		this.newsList.add(news);
	}

	public void addProduct(ProductDetail productDetail) {
		this.productDetailList.add(productDetail);
	}

}
