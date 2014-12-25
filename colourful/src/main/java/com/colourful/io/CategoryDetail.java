package com.colourful.io;

import lombok.Data;

@Data
public class CategoryDetail {

	/** 商品种ID */
	protected long categoryId;

	/** 图片路径 */
	protected String picturePath;

	/** 商品种别名 */
	protected String categoryName;

	/** 种别说明 */
	protected String description;

}
