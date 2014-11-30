package org.mybatis.jpetstore.domain.record;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class Cart implements Serializable {

	private static final long serialVersionUID = 8751282105532159742L;

	protected String userId;
	protected String itemId;
	protected String productId;
	protected BigDecimal quantity;
}
