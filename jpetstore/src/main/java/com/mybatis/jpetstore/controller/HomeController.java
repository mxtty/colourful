package com.mybatis.jpetstore.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.mybatis.jpetstore.domain.entity.Category;
import org.mybatis.jpetstore.service.CatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/index")
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	@Autowired
	private CatalogService catalogService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<Category> categoryList = catalogService.getCategoryList();
		for (Category ct : categoryList) {
			System.out.println(ct.getCategoryId());

			System.out.println(ct.getName());

		}
//		logger.info("Welcome home! the client locale is " + locale.toString());
//
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
//				DateFormat.LONG, locale);
//
//		String formattedDate = dateFormat.format(date);
//
//		model.addAttribute("serverTime", formattedDate);

		return "catalog/Main";
	}

}
