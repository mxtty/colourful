package com.colourful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.colourful.form.MenuForm;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@ModelAttribute("selectedMenuForm")
	public MenuForm initCartForm(Model model) {
		return new MenuForm();
	}

	@RequestMapping(value = "showMenu", method = RequestMethod.GET)
	public String menu(ModelMap model) {

		return "menu/Menu";

	}

}