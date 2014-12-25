package com.colourful.io;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDetail {
	/** 图片路径 */
	protected String picturePath;

	/** 商品名 */
	protected String productName;

	/** 单价 */
	protected BigDecimal unitPrice;

	/** 单位 */
	protected String unit;

	/** 商品ID */
	protected long productId;
}
