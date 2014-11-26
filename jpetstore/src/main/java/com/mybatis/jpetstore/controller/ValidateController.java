package com.mybatis.jpetstore.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.mybatis.jpetstore.io.OrderForm4Validate;
import org.mybatis.jpetstore.service.OrderService4Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rainbow.fw.core.exception.handler.ExceptionHandlerAdvice;
import com.rainbow.fw.web.context.ContextProvider;

@Controller
@RequestMapping("/validate")
public class ValidateController {

	@Autowired
	private OrderService4Validate vservice;

	@Autowired
	private MessageSource messageSource;

	private static Logger log = Logger.getLogger(ValidateController.class);

	@ModelAttribute("orderForm4Validate")
	public OrderForm4Validate initForm(Model model) {
		return new OrderForm4Validate();
	}

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	@ExceptionHandlerAdvice(errorPath = "pages/SignUpForm")
	public String addCustomer(@Valid @ModelAttribute OrderForm4Validate orderForm4Validate, BindingResult result) {
		if (orderForm4Validate.getAge() == 1) {
			vservice.createEntity().throwSysExceptionSample();
		} else {
			vservice.createEntity().throwAppExceptionSample();
		}
		/*
		 * for (Object object : result.getAllErrors()) { if (object instanceof
		 * FieldError) { FieldError fieldError = (FieldError) object;
		 * 
		 * System.out.println(fieldError.getField() + ":" +
		 * fieldError.getCode());
		 * 
		 * }
		 * 
		 * if (object instanceof ObjectError) { ObjectError objectError =
		 * (ObjectError) object;
		 * 
		 * } }
		 */

		// if (result.hasErrors()) {
		// return "pages/SignUpForm";
		// } else {
		// return "pages/Done";
		// }
		return "pages/Done";
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String displayCustomerForm(ModelMap model) {

		// DOMConfigurator.configure("WEB-INF/log4j.xml");

		ReloadableResourceBundleMessageSource res = (ReloadableResourceBundleMessageSource) ContextProvider
				.getBean("messageSource");
		res.clearCache();
		if (log.isDebugEnabled()) {
			log.debug(res.getMessage("test.properties", null, "", null));
		}

		log.error(res.getMessage("test.properties", null, "", null));
		System.out.println("test String is :" + res.getMessage("test.properties", null, "", null));
		// model.addAttribute("customer", new Customer());
		return "pages/SignUpForm";

	}
}