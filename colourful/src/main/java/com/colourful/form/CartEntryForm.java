package com.colourful.form;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartEntryForm {
	private long productId;
	private BigDecimal quantity;

}
