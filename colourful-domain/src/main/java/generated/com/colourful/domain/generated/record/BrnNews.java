package com.colourful.domain.generated.record;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;
@Data
public class BrnNews implements Serializable{
	/** SerialVersion */
	private static final long serialVersionUID = 1L;
	/** NEWS_ID */
	protected long newsId;
	/** 标题 */
	protected String title;
	/** 内容 */
	protected String contents;
	/** 作者 */
	protected String author;
	/** 类型 */
	protected int newsType;
	/** 创建时间 */
	protected Date createDate;
	/** 更新时间 */
	protected Date updateDate;
	/** 删除标记 */
	protected int delFlg;
}