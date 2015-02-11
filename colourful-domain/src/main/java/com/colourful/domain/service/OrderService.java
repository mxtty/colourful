package com.colourful.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.colourful.domain.data.ProductDetail;
import com.colourful.domain.entity.BrnCartDetailEntity;
import com.colourful.domain.entity.BrnOrderDetailEntity;
import com.colourful.domain.entity.BrnOrderEntity;
import com.colourful.domain.generated.record.BrnOrder;
import com.colourful.domain.service.base.EntityFactory;

@Service
public class OrderService {

	public void newOrder(String cartId, BrnOrder brnOrder, List<ProductDetail> productDetailList) {

		// 生成订单
		BrnOrderEntity orderEntity = EntityFactory.newEntity(BrnOrderEntity.class);
		orderEntity.fromObject(brnOrder);
		orderEntity.newOrder();

		BrnOrderDetailEntity orderDetailEntity = EntityFactory.newEntity(BrnOrderDetailEntity.class);
		orderDetailEntity.setOrderId(orderEntity.getOrderId());

		BrnCartDetailEntity cartDetailEntity = EntityFactory.newEntity(BrnCartDetailEntity.class);
		cartDetailEntity.setCartId(cartId);

		for (ProductDetail pd : productDetailList) {
			// 插入订单详细
			orderDetailEntity.setProductId(pd.getProductId());
			orderDetailEntity.setQuantity(pd.getQuantity());
			orderDetailEntity.setListPrice(pd.getUnitPrice());
			orderDetailEntity.setSubtotal(pd.getUnitPrice().multiply(pd.getQuantity()));
			orderDetailEntity.insert();
			// 从购物车移出
			cartDetailEntity.setProductId(pd.getProductId());
			cartDetailEntity.removeProduct(pd.getQuantity());

		}

	}
}
