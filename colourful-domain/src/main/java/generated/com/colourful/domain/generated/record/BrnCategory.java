package com.colourful.domain.generated.record;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;
@Data
public class BrnCategory implements Serializable{
	/** SerialVersion */
	private static final long serialVersionUID = 1L;
	/** 种别ID */
	protected long categoryId;
	/** 商品种别名 */
	protected String categoryName;
	/** 种别说明 */
	protected String description;
	/** 创建时间 */
	protected Date createDate;
	/** 更新时间 */
	protected Date updateDate;
	/** 删除标记 */
	protected int delFlg;
}