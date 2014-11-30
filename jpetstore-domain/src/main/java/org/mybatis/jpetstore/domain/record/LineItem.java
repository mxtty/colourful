package org.mybatis.jpetstore.domain.record;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class LineItem {
	private int orderId;
	private int lineNumber;
	private int quantity;
	private String itemId;
	private BigDecimal unitPrice;
	private BigDecimal total;
}
