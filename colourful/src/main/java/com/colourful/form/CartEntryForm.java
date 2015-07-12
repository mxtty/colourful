package com.colourful.form;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

import com.colourful.domain.data.ProductDetail;

@Data
public class CartEntryForm {
	private long productId;
	@Min(1)
	@Max(1500)
	@NotNull(message="请输入正确数字信息")
	private BigDecimal quantity;

	private ProductDetail productDetail;

}
