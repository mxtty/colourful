package com.colourful.domain.generated.record;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class BrnImage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2161539088541574506L;
	/** 图片ID */
	protected long imageId;
	/** 商品ID */
	protected long id;
	/** 图片序号 */
	protected int seq;
	/** 图片概要 */
	protected String note;
	/** 图片说明 */
	protected String description;
	/** 图片全路径 */
	protected String imageFile;
	/** 创建时间 */
	protected Date createDate;
	/** 更新时间 */
	protected Date updateDate;
	/** 删除标记 */
	protected int delFlg;
}