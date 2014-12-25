package com.colourful.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.colourful.io.CategoryDetail;
import com.colourful.io.ProductDetail;
import com.colourful.io.Products;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/catalog")
public class CategoryController {

	private static final Logger logger = LoggerFactory
			.getLogger(CategoryController.class);

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showCategories(ModelMap model) {

		List<CategoryDetail> categories = new ArrayList<CategoryDetail>();

		CategoryDetail cd = new CategoryDetail();
		cd.setCategoryId(10001);
		cd.setCategoryName("水饺类");
		cd.setPicturePath("page2-img1.jpg.res");
		cd.setDescription("本店特制手工水饺");

		CategoryDetail cd1 = new CategoryDetail();
		cd1.setCategoryId(10001);
		cd1.setCategoryName("包子类");
		cd1.setPicturePath("page2-img2.jpg.res");
		cd1.setDescription("本店特制手工包子");
		
		categories.add(cd);
		categories.add(cd1);
		model.addAttribute("categories", categories);
		return "catalog/displayCategories";

	}

	@RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
	public String showProducts(@PathVariable String categoryId, ModelMap model) {
		System.out.println(categoryId);


		ProductDetail pd1 = new ProductDetail();
		pd1.setPicturePath("C:\\Users\\WangQi\\Pictures\\Model Plane\\F3A\\F3A_1.jpg");
		pd1.setProductId(10001);
		pd1.setProductName("猪肉水饺");


		List<ProductDetail> productsList = new ArrayList<ProductDetail>();
		productsList.add(pd1);
		productsList.add(pd1);
		productsList.add(pd1);
		productsList.add(pd1);

		model.addAttribute("productsList",productsList);
		model.addAttribute("catetoryName", "凉菜类");
		return "product/displayProducts";

	}
}
