package com.colourful.domain.generated.record;
import java.io.Serializable;
import lombok.Data;
import java.math.BigDecimal;import java.util.Date;
@Data
public class BrnOrderDetail implements Serializable{
	/** SerialVersion */
	private static final long serialVersionUID = 1L;
	/** 订单详细ID */
	protected long detailId;
	/** 订单ID */
	protected long orderId;
	/** 商品ID */
	protected long productId;
	/** 商品数量 */
	protected BigDecimal quantity;
	/** 卖出单价 */
	protected BigDecimal listPrice;
	/** 商品成本 */
	protected BigDecimal unitCost;
	/** 小计 */
	protected BigDecimal subtotal;
	/** 订单状态 */
	protected int status;
	/** 创建时间 */
	protected Date createDate;
	/** 更新时间 */
	protected Date updateDate;
	/** 删除标记 */
	protected int delFlg;
}