package com.colourful.domain.generated.record;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;
@Data
public class BrnUser implements Serializable{
	/** SerialVersion */
	private static final long serialVersionUID = 1L;
	/** 用户ID */
	protected String userId;
	/** 真实名 */
	protected String realName;
	/** 密码 */
	protected String passwd;
	/** 住址ID */
	protected long addressId;
	/** 用户状态 */
	protected int status;
	/** 创建时间 */
	protected Date createDate;
	/** 更新时间 */
	protected Date updateDate;
	/** 删除标记 */
	protected int delFlg;
}