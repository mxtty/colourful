package com.colourful.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.colourful.domain.entity.BrnUserDetailEntity;
import com.colourful.domain.entity.BrnUserEntity;
import com.colourful.domain.service.base.EntityFactory;
import com.colourful.io.RegisterUserForm;
import com.rainbow.fw.core.exception.handler.ExceptionHandlerAdvice;

@Controller
@RequestMapping("/registerUser")
public class RegisterUserController {

	@Autowired
	private MessageSource messageSource;

	private static Logger log = Logger.getLogger(RegisterUserController.class);

	@ModelAttribute("registerUserForm")
	public RegisterUserForm initForm(Model model) {
		return new RegisterUserForm();
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	// @ExceptionHandlerAdvice(errorPath = "registerUser/register")
	public String addNewUser(
			@Valid @ModelAttribute RegisterUserForm registerUserForm,
			BindingResult result, Model model) {

		BrnUserDetailEntity detailEntity = EntityFactory
				.newBrnUserDetailEntity(registerUserForm.getUserId());

		detailEntity.fromObject(registerUserForm);
		detailEntity.setDefaultFlg(1);
		detailEntity.insert();
		System.out.println("ERROR");
		BrnUserEntity userEntity = EntityFactory
				.newBrnUserEntity(registerUserForm.getUserId());
		userEntity.fromObject(registerUserForm);
		if (1 == 1) {
			throw new RuntimeException("ERROR");
		}
		boolean ret = userEntity.insert();
		System.out.println("============IN ADD NEW==============" + ret);
		return "registerUser/done";
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String displayRegisterUserForm(ModelMap model) {

		return "registerUser/new";

	}
}