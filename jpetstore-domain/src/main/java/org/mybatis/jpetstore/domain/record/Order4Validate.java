package org.mybatis.jpetstore.domain.record;

import java.math.BigDecimal;

import lombok.Data;

import org.mybatis.jpetstore.code.CardType;

@Data
public class Order4Validate {
	private CardType cardType;
	private String billToFirstName;
	private String billToLastName;
	private int age;
	private String billAddress1;
	private BigDecimal totalPrice;
	private String billAddress2;
	private String billCity;

}
