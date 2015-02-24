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
import com.colourful.form.RegisterUserForm;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private MessageSource messageSource;

	private static Logger log = Logger.getLogger(UserController.class);

	@ModelAttribute("registerUserForm")
	public RegisterUserForm initForm(Model model) {
		return new RegisterUserForm();
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	// @ExceptionHandlerAdvice(errorPath = "registerUser/register")
	public String addNewUser(@Valid @ModelAttribute RegisterUserForm registerUserForm, BindingResult result, Model model) {

		BrnUserDetailEntity detailEntity = EntityFactory.newBrnUserDetailEntity(registerUserForm.getUserId());

		detailEntity.fromObject(registerUserForm);
		detailEntity.setDefaultFlg(1);
		detailEntity.insert();
		BrnUserEntity userEntity = EntityFactory.newBrnUserEntity(registerUserForm.getUserId());
		userEntity.fromObject(registerUserForm);
		userEntity.setAddressId(detailEntity.getAddressId());
		boolean ret = userEntity.insert();
		System.out.println("============IN ADD NEW==============" + ret);
		return "account/RegisterDone";
	}

	@RequestMapping(value = "auth", method = RequestMethod.GET)
	public String signOnShow(ModelMap model) {

		return "account/SignOn";

	}
	
	@RequestMapping(value = "SignOn", method = RequestMethod.GET)
	public String signOn(ModelMap model) {

		return "account/SignOn";

	}
	
	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String displayRegisterUserForm(ModelMap model) {

		return "account/RegisterUser";

	}
}