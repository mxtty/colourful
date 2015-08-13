package com.colourful.domain.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;

import com.colourful.domain.entity.BrnUserEntity;
import com.colourful.domain.service.CartService;
import com.colourful.domain.service.base.EntityFactory;

public class AuthenticationSuccessListenerImpl implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

	@Autowired
	private CartService cartService;

	public void onAuthenticationFailed(AbstractAuthenticationFailureEvent event) {
		// TODO Auto-generated method stub

	}

	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
		// TODO Auto-generated method stub
		UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();
		BrnUserEntity userEntity = EntityFactory.newBrnUserEntity(userDetails.getUsername());
		userEntity.getEntityByPk();
		cartService.changeCartIdByUser(userEntity.getCartId());
		
	}

}
