package com.rainbow.fw.core.auth;

import lombok.Getter;
import lombok.Setter;

public class AnonymousUserDetails implements WebUser {

	@Getter
	@Setter
	private String cartId;

	public void setUserId(String userId) {

	}

	public String getUserId() {
		return "guest";
	}

	public boolean isAnonymousUser() {
		return true;
	}

}
