package com.colourful.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

import org.hibernate.validator.constraints.NotEmpty;

@Data
public class MessageBoardForm {
	/** 标题 */
	@NotEmpty
	private String title;
	/** 内容 */
	@NotEmpty
	private String contents;
	/** 姓名 */
	private String userName;
	/** 电话 */
	@Pattern(regexp = "[0-9-]+", message = "{number.formart.error}")
	@Size(min = 1, max = 20)
	protected String phone;
	/** 电子邮箱 */
	@Size(min = 3, max = 50)
	protected String email;
}
