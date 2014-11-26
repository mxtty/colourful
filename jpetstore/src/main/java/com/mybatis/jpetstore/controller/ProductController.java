package com.mybatis.jpetstore.controller;

import java.util.List;

import org.mybatis.jpetstore.domain.entity.Product;
import org.mybatis.jpetstore.domain.record.Item;
import org.mybatis.jpetstore.service.CartService;
import org.mybatis.jpetstore.service.CatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private CatalogService catalogService;

	@Autowired
	private CartService cartService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "detail/{productId}")
	public String itemList(@PathVariable String productId, Model model) {
		List<Item> itemList = catalogService.getItemListByProduct(productId);

		Product product = catalogService.getProduct(productId);

		model.addAttribute("itemList", itemList);
		model.addAttribute("product", product);
		return "catalog/Product";
	}

	@RequestMapping(value = "item/{itemId}")
	public String itemDetail(@PathVariable String itemId, Model model) {
		Item item = catalogService.getItem(itemId);
		model.addAttribute("item", item);
		model.addAttribute("product", item.getProduct());
		return "catalog/Item";
	}

	@RequestMapping(value = "add/{itemId}")
	public String addToCart(@PathVariable String itemId, Model model) {

		//cartService.addItem(itemId);

		//model.addAttribute("cart", cartService.getCartEntity());
		return "cart/CartEntity";
	}

}
