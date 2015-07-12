package com.colourful.domain.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import com.sun.istack.internal.NotNull;

@Data
public class ProductDetail {

	/** 商品ID */
	private long productId;

	/** 商品名 */
	private String productName;

	/** 图片路径 */
	private String imgFileMain;

	private List<String> imgFileSubList = new ArrayList<String>();

	/** 单价 */
	private BigDecimal unitPrice;

	/** 单位 */
	private String unit;

	@NotNull
	private BigDecimal quantity;

	private String description;

	public BigDecimal getSubTotal() {
		return quantity.multiply(unitPrice);
	}

	public void addImgFileSub(String imgFileSub) {
		if (null != imgFileSub) {
			imgFileSubList.add(imgFileSub);
		}
	}

}
