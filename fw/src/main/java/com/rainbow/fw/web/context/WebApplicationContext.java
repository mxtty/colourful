package com.rainbow.fw.web.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.rainbow.fw.core.auth.AnonymousUserDetails;
import com.rainbow.fw.core.auth.WebUser;

@Component
public class WebApplicationContext {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpServletResponse response;

	@Autowired
	private HttpSession session;

	private static final String CURRENT_CART_ID = "currentCartId";

	public <T> T getUserDetails(Class<T> cls) {

		@SuppressWarnings("unchecked")
		T principal = (T) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return principal;

	}

	public String getCurrentCartId() {
		Object currentCartId = session.getAttribute(CURRENT_CART_ID);
		return null != currentCartId ? currentCartId.toString() : null;
	}

	public void setCurrentCartId(String cartId) {
		session.setAttribute(CURRENT_CART_ID, cartId);
	}

	public String getSessionId() {
		return session.getId();
	}

	public WebUser getUserDetails() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof WebUser) {
			return (WebUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}

		return new AnonymousUserDetails();
	}

	public boolean isAuthenticated() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (null == authentication || null == authentication.getPrincipal())
			return false;

		Object principal = authentication.getPrincipal();

		if (principal instanceof WebUser)
			return true;
		return false;
	}
}
