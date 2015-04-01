package com.colourful.form;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

import com.colourful.domain.data.ProductDetail;

@Data
public class MenuForm {

	private List<ProductDetail> productDetailList;
}
