package com.colourful.form;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

import com.colourful.domain.data.ProductDetail;

@Data
public class CartForm {
	private String cartId;
	private BigDecimal total;
	private BigDecimal shipping;
	private List<ProductDetail> productDetailList;
	
}
