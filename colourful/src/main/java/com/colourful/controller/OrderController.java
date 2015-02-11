package com.colourful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.colourful.form.OrderEntryForm;

/**
 * 
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@ModelAttribute("orderEntryForm")
	public OrderEntryForm initForm(Model model) {
		return new OrderEntryForm();
	}

	@RequestMapping(value = "newOrder")
	public String submit(ModelMap model) {

		return "order/OrderFinish";

	}

}
