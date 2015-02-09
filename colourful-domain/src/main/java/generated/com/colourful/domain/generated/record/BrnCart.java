package com.colourful.domain.generated.record;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;
@Data
public class BrnCart implements Serializable{
	/** SerialVersion */
	private static final long serialVersionUID = 1L;
	/** 购物车ID */
	protected String cartId;
	/** 用户ID */
	protected String userId;
	/** 创建时间 */
	protected Date createDate;
	/** 更新时间 */
	protected Date updateDate;
	/** 删除标记 */
	protected int delFlg;
}