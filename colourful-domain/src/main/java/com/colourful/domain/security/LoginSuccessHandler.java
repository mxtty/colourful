package com.colourful.domain.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.colourful.domain.entity.BrnUserEntity;
import com.colourful.domain.service.CartService;
import com.colourful.domain.service.base.EntityFactory;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Setter
	@Autowired
	private CartService cartService;

	@Setter
	@Getter
	private String defaultTargetUrl;

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		//
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		BrnUserEntity userEntity = EntityFactory.newBrnUserEntity(userDetails.getUsername());
		userEntity.getEntityByPk();
		cartService.changeCartIdByUser(userEntity.getCartId());

	}

}
