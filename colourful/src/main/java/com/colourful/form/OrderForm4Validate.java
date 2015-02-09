package com.colourful.form;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

import com.colourful.domain.code.CardType;

@Data
public class OrderForm4Validate {

	private CardType cardType;

	// @Size(min = 10, max = 20)
	private String billToFirstName;
	private String billToLastName;

	// @Range(min = 1, max = 120)
	// @Pattern(regexp = "^[0-9]*$", message="{number.formart.error}")
	@NotEmpty
	// @NumberFormat(style = Style.NUMBER)
	//@NumberOrNull
	private Integer age;
	// @NotEmpty
	private String billAddress1;
	// @NotNull
	private BigDecimal totalPrice;
	private String billAddress2;
	private String billCity;

}
