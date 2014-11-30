package com.colourful.io;

import lombok.Data;

import org.hibernate.validator.constraints.NotEmpty;

@Data
public class RegisterUserForm {

	/** 用户ID */
	@NotEmpty
	protected String userId;

	/** 用户名 */
	@NotEmpty
	protected String realName;

	/** 密码 */
	@NotEmpty
	protected String passwd;

	/** 密码确认 */
	@NotEmpty
	protected String passwdConfirm;

	/** 电话 */
	protected String phone;

	/** 手机 */
	protected String cellPhone;

	/** 电子邮箱 */
	protected String email;

	/** 邮编 */
	@NotEmpty
	protected String zip;

	/** 住址 */
	@NotEmpty
	protected String address;

}