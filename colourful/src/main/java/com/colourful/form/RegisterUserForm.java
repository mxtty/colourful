package com.colourful.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class RegisterUserForm {

	/** 用户ID */
	@NotEmpty
	@Size(min = 4, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9_-]{4,20}", message = "{user.id.error}")
	protected String userId;

	/** 用户名 */
	@NotEmpty
	protected String realName;

	/** 密码 */
	@NotEmpty
	@Size(min = 4, max = 20)
	protected String passwd;

	/** 密码确认 */
	@NotEmpty
	@Size(min = 4, max = 20)
	protected String passwdConfirm;

	/** 电话 */
	@Pattern(regexp = "[0-9-]+", message = "{number.formart.error}")
	protected String phone;

	/** 手机 */
	@NotEmpty
	@Pattern(regexp = "[0-9-]+", message = "{number.formart.error}")
	protected String cellPhone;

	/** 电子邮箱 */
	@Email
	protected String email;

	/** 邮编 */
	@NotEmpty
	@Pattern(regexp = "[0-9-]+", message = "{number.formart.error}")
	protected String zip;

	/** 住址 */
	@NotEmpty
	protected String address;

}