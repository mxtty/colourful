package com.rainbow.fw.security;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;

public class AuthenticationSuccessImpl implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

	@Autowired
	@Setter
	private AuthenticationService authenticationService;

	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
		authenticationService.onAuthenticationSuccess(event);
	}
}