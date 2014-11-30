package com.colourful.controller;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.colourful.domain.data.MyCart;
import com.colourful.domain.entity.CartEntity;
import com.colourful.domain.querydata.CartItem;
import com.colourful.domain.service.base.EntityFactory;
import com.colourful.io.OrderForm;
import com.rainbow.fw.core.env.Enviroment;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/cart")
@SessionAttributes({ "orderForm" })
public class CartController {

	private static final Logger logger = LoggerFactory
			.getLogger(CartController.class);

	@Autowired
	private Enviroment env;

	@ModelAttribute("orderForm")
	public OrderForm initForm(Model model) {
		return new OrderForm();
	}

	@RequestMapping(value = "add/{itemId}/{productId}")
	public String addToCart(@PathVariable String itemId,
			@PathVariable String productId,
			@ModelAttribute OrderForm orderForm, Model model) {
		String userId = env.getUserDetails().getUsername();
		CartEntity cartEntity = EntityFactory.newCartEntity(userId, itemId,
				productId);
		cartEntity.addItemQuantity(BigDecimal.ONE);

		MyCart myCart = new MyCart();
		List<CartItem> cartList = cartEntity.getCarItemsByUserId(userId);
		myCart.setCartItems(cartList);
		orderForm.setCartList(cartList);
		// ItemEntity itemEntity = cartEntity.getItemEntity();
		// System.out.println("Item Entity :" + itemEntity.getListPrice() +
		// " Unit Cost:" + itemEntity.getUnitCost());
		model.addAttribute("myCart", myCart);
		return "cart/Cart";
	}
}
