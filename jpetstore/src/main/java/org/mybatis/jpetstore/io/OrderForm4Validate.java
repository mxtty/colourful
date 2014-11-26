package org.mybatis.jpetstore.io;

import java.math.BigDecimal;

import lombok.Data;

import org.mybatis.jpetstore.code.CardType;

import com.rainbow.fw.web.validation.annotation.NumberOrNull;

@Data
public class OrderForm4Validate {

	private CardType cardType;

	// @Size(min = 10, max = 20)
	private String billToFirstName;
	private String billToLastName;

	// @Range(min = 1, max = 120)
	// @Pattern(regexp = "^[0-9]*$", message="{number.formart.error}")
	// @NotNull
	// @NumberFormat(style = Style.NUMBER)
	@NumberOrNull
	private Integer age;
	// @NotEmpty
	private String billAddress1;
	// @NotNull
	private BigDecimal totalPrice;
	private String billAddress2;
	private String billCity;

}
