package com.colourful.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.colourful.io.ProductDetail;
import com.colourful.io.Products;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	private static final Logger logger = LoggerFactory
			.getLogger(ProductController.class);

	@RequestMapping(value = "add/{itemId}")
	public String addToCart(@PathVariable String itemId, Model model) {

		// cartService.addItem(itemId);

		// model.addAttribute("cart", cartService.getCartEntity());
		return "cart/CartEntity";
	}

	@RequestMapping(value = "showProducts/{categoryId}", method = RequestMethod.GET)
	public String displayProducts(ModelMap model) {

		List<Products> productsList = new ArrayList<Products>();

		Products p1 = new Products();
		p1.setCatetoryName("水饺类");
		ProductDetail pd1 = new ProductDetail();
		//pd1.setPicturePath("/resources/images/page2-img1.jpg");
		pd1.setPicturePath("C:\\Users\\WangQi\\Pictures\\Model Plane\\F3A\\F3A_1.jpg");
		
		pd1.setProductId(10001);
		pd1.setProductName("猪肉水饺");
		p1.addProduct(pd1);
		p1.addProduct(pd1);
		p1.addProduct(pd1);
		p1.addProduct(pd1);
		p1.addProduct(pd1);
		p1.addProduct(pd1);

		productsList.add(p1);
		productsList.add(p1);
		productsList.add(p1);
		System.out.println("P1" + p1.getCatetoryName());
		model.addAttribute(productsList);
		return "product/displayProducts";

	}
}
