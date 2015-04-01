package com.rainbow.fw.core.env;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.rainbow.fw.core.auth.AnonymousUserDetails;
import com.rainbow.fw.core.auth.WebUser;

@Component
public class Enviroment {

	@Autowired
	private HttpSession session;

	public <T> T getUserDetails(Class<T> cls) {

		@SuppressWarnings("unchecked")
		T principal = (T) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return principal;

	}

	public String getCartId() {
		if (!isAuthenticated())
			return session.getId();
		return getUserDetails().getCartId();
	}

	public WebUser getUserDetails() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth.isAuthenticated()) {
			return (WebUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}

		return new AnonymousUserDetails();
	}

	public boolean isAuthenticated() {
		return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
	}
}
