package com.rainbow.fw.web.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.rainbow.fw.web.validation.validator.NumberOrNullValidator;

@Documented
@Constraint(validatedBy = NumberOrNullValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberOrNull {

	String message() default "{NumberOrNull}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}