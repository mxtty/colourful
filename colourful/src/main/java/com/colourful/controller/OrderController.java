package com.colourful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.colourful.io.OrderDetailForm;
import com.colourful.io.ProductDetail;

/**
 * 
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@ModelAttribute("orderDetailForm")
	public OrderDetailForm initForm(Model model) {
		return new OrderDetailForm();
	}

	@RequestMapping(value = "viewOrder")
	public String addToCart(Model model) {

		// cartService.addItem(itemId);

		// model.addAttribute("cart", cartService.getCartEntity());
		return "order/ViewOrder";
	}

	@RequestMapping(value = "submit")
	public String submit( ModelMap model) {

		return "order/OrderFinish";

	}

}
