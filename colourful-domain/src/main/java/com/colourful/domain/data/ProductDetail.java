package com.colourful.domain.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ProductDetail {
	/** 图片路径 */
	private String imgFileMain;

	private List<String> imgFileSubList = new ArrayList<String>();

	/** 商品名 */
	private String productName;

	/** 单价 */
	private BigDecimal unitPrice;

	/** 单位 */
	private String unit;

	private BigDecimal quantity;

	private String description;

	/** 商品ID */
	private long productId;

	public void addImgFileSub(String imgFileSub) {
		if (null != imgFileSub) {
			imgFileSubList.add(imgFileSub);
		}
	}

}
