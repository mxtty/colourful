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

	@ModelAttribute("menuForm")
	public MenuForm initCartForm(Model model) {
		return new MenuForm();
	}

	@RequestMapping(value = "showMenu")
	public String menu(Model model) {

		return "menu/Menu";

	}

}