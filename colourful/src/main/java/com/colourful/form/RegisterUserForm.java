package com.colourful.form;

import javax.validation.constraints.AssertTrue;
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
	@Size(min = 1, max = 20)
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
	@Size(min = 1, max = 20)
	protected String phone;

	/** 手机 */
	@NotEmpty
	@Pattern(regexp = "[0-9-]+", message = "{number.formart.error}")
	@Size(min = 1, max = 20)
	protected String cellPhone;

	/** 电子邮箱 */
	@Email
	@Size(min = 3, max = 50)
	protected String email;

	/** 邮编 */
	@NotEmpty
	@Pattern(regexp = "[0-9-]+", message = "{number.formart.error}")
	@Size(min = 1, max = 20)
	protected String zip;

	/** 住址 */
	@NotEmpty
	@Size(min = 1, max = 200)
	protected String address;

	public boolean isSamePasswdInput() {
		if (null == this.passwd || null == this.passwdConfirm) {
			return false;
		}

		if (this.passwd.equals(this.passwdConfirm)) {
			return true;
		}

		return false;
	}

}