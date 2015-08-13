package com.rainbow.fw.security;

import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;

public interface AuthenticationService {
	void onAuthenticationSuccess(InteractiveAuthenticationSuccessEvent event);

	void onAuthenticationFailed(AbstractAuthenticationFailureEvent event);
}
