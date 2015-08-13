package com.colourful.controller;

import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.colourful.domain.data.RainbowUserDetails;
import com.colourful.domain.entity.BrnUserDetailEntity;
import com.colourful.domain.entity.BrnUserEntity;
import com.colourful.domain.exception.ExceptionId;
import com.colourful.domain.service.base.EntityFactory;
import com.colourful.form.RegisterUserForm;
import com.rainbow.fw.core.exception.handler.ExceptionHandlerAdvice;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private MessageSource messageSource;

	@ModelAttribute("registerUserForm")
	public RegisterUserForm initForm(Model model) {
		return new RegisterUserForm();
	}

	@RequestMapping(value = "RegisterDone", method = RequestMethod.POST)
	@ExceptionHandlerAdvice(errorPath = "account/RegisterUser")
	public String addNewUser(@Valid @ModelAttribute RegisterUserForm registerUserForm, BindingResult result, Model model) {

		if (!registerUserForm.isSamePasswdInput()) {
			ExceptionId.RB10001I.rejectApp();
		}

		BrnUserEntity userEntity = EntityFactory.newBrnUserEntity(registerUserForm.getUserId());
		if (userEntity.isUserExists()) {
			ExceptionId.RB10002I.rejectApp(registerUserForm.getUserId());
		}

		BrnUserDetailEntity detailEntity = EntityFactory.newEntity(BrnUserDetailEntity.class);
		detailEntity.fromObject(registerUserForm);
		detailEntity.setDefaultFlg(1);
		detailEntity.insert();

		userEntity.fromObject(registerUserForm);
		userEntity.setAddressId(detailEntity.getAddressId());
		boolean ret = userEntity.insertNewUser();

		System.out.println("============IN ADD NEW==============" + ret);

		// ExceptionId.appeid.rejectApp("业务异常");
		return "account/RegisterDone";
	}

	@RequestMapping(value = "auth", method = RequestMethod.POST)
	public String signOnShow(Model model) {

		return "account/SignOn";

	}

	@RequestMapping(value = "SignOnError", method = RequestMethod.GET)
	public String signOnError(Model model) {

		model.addAttribute("errors", "用户名或者密码错误，请重新输入！");

		return "account/SignOn";
	}

	@RequestMapping(value = "SignOn", method = RequestMethod.GET)
	public String signOn(Principal principal, HttpSession session,
			@CookieValue(value = "cartId", defaultValue = "") String cartId, HttpServletResponse response, Model model) {
		if (StringUtils.isEmpty(cartId)) {
			Cookie cookie = new Cookie("cartId", session.getId());
			// 有效期限180天
			cookie.setMaxAge(60 * 60 * 24 * 180);
			// cookie.setSecure(true);
			cartId = session.getId();
			response.addCookie(cookie);
		}

		if (null != principal) {
			Authentication authentication = (Authentication) principal;

			RainbowUserDetails userDetails = (RainbowUserDetails) authentication.getPrincipal();
			//userDetails.setCartId(cartId);
		}

		return "account/SignOn";
	}

	@RequestMapping(value = "RegisterUser", method = RequestMethod.GET)
	public String displayRegisterUserForm(Model model) {

		System.out.println("IN REGISTER");
		return "account/RegisterUser";

	}

	@RequestMapping(value = "MyAccount", method = RequestMethod.GET)
	public String displayMyAccount(Model model) {

		return "account/MyAccount";

	}
}