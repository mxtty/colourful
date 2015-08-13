package com.colourful.domain.data;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.colourful.domain.generated.record.BrnNews;

@Data
public class HomeContents {

	/** 首页主图 */
	private String sliderFile;

	/** 首页辅图 */
	private String homeSubImgFile;

	/** 简讯 */
	private BrnNews newsletter;

	/** 新闻 */
	private List<BrnNews> newsList = new ArrayList<BrnNews>();

	private List<ProductDetail> productDetailList = new ArrayList<ProductDetail>();

	public void addNews(List<BrnNews> newsList) {
		this.newsList.addAll(newsList);
	}

	public void addProduct(ProductDetail productDetail) {
		this.productDetailList.add(productDetail);
	}

}
