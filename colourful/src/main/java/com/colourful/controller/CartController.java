package com.colourful.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.colourful.domain.service.CartService;
import com.colourful.form.OrderEntryForm;

/**
 * 
 */
@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@ModelAttribute("orderEntryForm")
	public OrderEntryForm initForm(Model model) {
		return new OrderEntryForm();
	}

	@RequestMapping(value = "add")
	public String addToCart(HttpSession session, @CookieValue(value = "sid", defaultValue = "") String sid,
			HttpServletResponse response, @Valid @ModelAttribute OrderEntryForm orderEntryForm, BindingResult result,
			Model model) {
		System.out.println("PID:" + orderEntryForm.getProductId() + "QAN:" + orderEntryForm.getQuantity());
		if (StringUtils.isEmpty(sid)) {
			Cookie cookie = new Cookie("sid", session.getId());
			// 有效期限180天
			cookie.setMaxAge(60 * 60 * 24 * 180);
			// cookie.setSecure(true);
			sid = session.getId();
			response.addCookie(cookie);
		}

		cartService.addToCart(orderEntryForm.getProductId(), orderEntryForm.getQuantity(), sid);

		// cartService.addItem(itemId);

		// model.addAttribute("cart", cartService.getCartEntity());
		return "forward:/cart/showCart";
	}

	@RequestMapping(value = "showCart")
	public String showCart(HttpSession session, @CookieValue(value = "sid", defaultValue = "") String sid) {
		return "cart/Cart";
	}

	@RequestMapping(value = "checkout")
	public String checkOut(ModelMap model) {
		return "cart/Checkout";
	}
}
