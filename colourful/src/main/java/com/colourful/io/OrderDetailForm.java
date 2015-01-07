package com.colourful.io;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderDetailForm {
	private long productId;
	private BigDecimal quantity;
}
