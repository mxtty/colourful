package com.colourful.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.colourful.domain.data.CategoryDetail;
import com.colourful.domain.entity.BrnCategoryEntity;
import com.colourful.domain.service.CategoryService;
import com.colourful.domain.service.base.EntityFactory;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/catalog")
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showCategories(ModelMap model) {

	List<CategoryDetail> categories = categoryService.getAllCategories();

	model.addAttribute("categories", categories);
	return "catalog/Category";
    }

    @RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
    public String showProducts(@PathVariable long categoryId, ModelMap model) {
	System.out.println(categoryId);

	// ProductDetail pd1 = new ProductDetail();
	// pd1.setImgFileMain("c1001_10001_img3.jpg");
	// pd1.setUnit("份");
	// pd1.setUnitPrice(BigDecimal.valueOf(11.8));
	// pd1.setProductId(10001);
	// pd1.setProductName("猪肉水饺");
	//
	// Products products = new Products();
	// products.setCategoryId(categoryId);
	// products.setCategoryName("水饺类");
	// products.addProduct(pd1);
	// products.addProduct(pd1);
	// products.addProduct(pd1);
	// products.addProduct(pd1);
	// products.addProduct(pd1);
	// products.addProduct(pd1);

	BrnCategoryEntity categoryEntity = EntityFactory.newBrnCategoryEntity(categoryId);

	model.addAttribute("products", categoryEntity.getProducts());
	// model.addAttribute("products", products);
	return "product/ProductList";

    }
    
}
