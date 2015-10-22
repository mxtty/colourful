package com.colourful.domain.generated.record;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;
@Data
public class BrnMessageBoard implements Serializable{
	/** SerialVersion */
	private static final long serialVersionUID = 1L;
	/** 留言ID */
	protected long messageBoardId;
	/** 标题 */
	protected String title;
	/** 内容 */
	protected String contents;
	/** 固定电话 */
	protected String phone;
	/** 邮件地址 */
	protected String email;
	/** 姓名 */
	protected String userName;
	/** 用户ID */
	protected String userId;
	/** 创建时间 */
	protected Date createDate;
	/** 更新时间 */
	protected Date updateDate;
	/** 删除标记 */
	protected int delFlg;
}