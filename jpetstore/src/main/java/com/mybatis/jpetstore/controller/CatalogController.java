package com.mybatis.jpetstore.controller;

import java.util.List;

import org.mybatis.jpetstore.domain.entity.Product;
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
@RequestMapping("/category")
public class CatalogController {

	private static final Logger logger = LoggerFactory
			.getLogger(CatalogController.class);
	@Autowired
	private CatalogService catalogService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "find/{categoryId}")
	public String home(@PathVariable String categoryId, Model model) {
		List<Product> productList = catalogService
				.getProductListByCategory(categoryId);

		model.addAttribute("productList", productList);
		return "catalog/Category";
	}
}
