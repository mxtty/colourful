package com.colourful.domain.generated.record;
import java.io.Serializable;
import lombok.Data;
import java.math.BigDecimal;import java.util.Date;
@Data
public class BrnProduct implements Serializable{
	/** SerialVersion */
	private static final long serialVersionUID = 1L;
	/** 商品ID */
	protected long productId;
	/** 商品名 */
	protected String productName;
	/** 单位 */
	protected String unit;
	/** 单价 */
	protected BigDecimal unitPrice;
	/** 商品成本 */
	protected BigDecimal unitCost;
	/** 种别类型1 */
	protected long categoryId1;
	/** 种别类型2 */
	protected long categoryId2;
	/** 种别类型3 */
	protected long categoryId3;
	/** 种别类型4 */
	protected long categoryId4;
	/** 种别类型5 */
	protected long categoryId5;
	/** 商品说明 */
	protected String description;
	/** 商品状态 */
	protected int status;
	/** 创建时间 */
	protected Date createDate;
	/** 更新时间 */
	protected Date updateDate;
	/** 删除标记 */
	protected int delFlg;
}