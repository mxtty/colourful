package com.rainbow.fw.core.auth;

public interface WebUser {
	String getUserId();

	String getCartId();

	void setCartId(String cartId);

	boolean isAnonymousUser();
}