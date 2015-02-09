package com.colourful.form;

import java.math.BigDecimal;

import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class OrderEntryForm {

	private long productId;
	@Min(value = 1)
	private BigDecimal quantity;
}
