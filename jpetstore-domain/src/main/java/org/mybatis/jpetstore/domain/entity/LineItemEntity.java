package org.mybatis.jpetstore.domain.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.mybatis.jpetstore.domain.base.LineItemBase;
import org.mybatis.jpetstore.domain.record.LineItem;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
@Scope("prototype")
public class LineItemEntity extends LineItemBase implements Serializable {

	private static final long serialVersionUID = 6804536240033522156L;

	public List<LineItem> getListBy(int orderId) {
		return lineItemMapper.getLineItemsByOrderId(orderId);
	}
}
