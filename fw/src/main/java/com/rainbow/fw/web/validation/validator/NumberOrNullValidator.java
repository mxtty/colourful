package com.rainbow.fw.web.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.rainbow.fw.web.validation.annotation.NumberOrNull;

public class NumberOrNullValidator implements ConstraintValidator<NumberOrNull, Integer> {

	public void initialize(NumberOrNull constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if (null == value) {
			return false;
		}
		return true;
		// return value.matches("[0-9]*");
	}

}
