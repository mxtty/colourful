package com.colourful.domain.generated.record;


import java.io.Serializable;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class BrnCartDetail implements Serializable{

	/** SerialVersion */
	private static final long serialVersionUID = 1L;


	/** 购物车ID */
	protected long cartId;

	/** 商品ID */
	protected long productId;

	/** 商品数量 */
	protected BigDecimal quantity;

	/** 卖出单价 */
	protected BigDecimal listPrice;

	/** 购物状态 */
	protected int status;

	/** 创建时间 */
	protected Date createDate;

	/** 更新时间 */
	protected Date updateDate;

	/** 删除标记 */
	protected int delFlg;

}
