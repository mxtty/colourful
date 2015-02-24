package com.colourful.domain.data;

import java.util.List;

import lombok.Data;

import com.colourful.domain.generated.record.BrnOrder;

@Data
public class OrderHistory {
	BrnOrder brnOrder;
	List<ProductDetail> productDetailList;
}
