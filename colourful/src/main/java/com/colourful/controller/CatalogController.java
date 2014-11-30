package com.colourful.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.colourful.domain.entity.Product;
import com.colourful.domain.service.CatalogService;

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
		String sessionID = RequestContextHolder.currentRequestAttributes()
				.getSessionId();

		System.out.println("SESSION_ID(" + sessionID + ")");

		model.addAttribute("productList", productList);
		return "catalog/Category";
	}
}
