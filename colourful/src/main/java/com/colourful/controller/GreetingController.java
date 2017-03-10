package com.colourful.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.colourful.form.Customer;
import com.colourful.form.Grade;

@RestController
@RequestMapping("/greeting")
@SessionAttributes({ "menuForm" })
public class GreetingController {

	@Autowired
	private MessageSource messageSource;

	private static Logger log = Logger.getLogger(GreetingController.class);

	@RequestMapping(value = "sample", method = RequestMethod.GET)
	@ResponseBody
	public Customer sample(Model model) {
		Customer cs = new Customer();
		cs.setName("Test User33333");

		return cs;
	}

	@RequestMapping(value = "grade", method = RequestMethod.GET)
	@ResponseBody
	public List<Grade> getGradeList() {
		Grade myGrade1 = new Grade();
		myGrade1.setGradeCode("1001");
		myGrade1.setGradeName("一年级");

		Grade myGrade2 = new Grade();
		myGrade2.setGradeCode("1002");
		myGrade2.setGradeName("二年级");

		Grade myGrade3 = new Grade();
		myGrade3.setGradeCode("1003");
		myGrade3.setGradeName("三年级");

		List<Grade> gradeList = new ArrayList<Grade>();
		gradeList.add(myGrade1);
		gradeList.add(myGrade2);
		gradeList.add(myGrade3);

		return gradeList;
	}
}