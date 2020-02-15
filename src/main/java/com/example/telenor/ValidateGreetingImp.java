package com.example.telenor;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidateGreetingImp implements ConstraintValidator<ValidateGreeting, String> {

	List<String> valueList = null;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return valueList.contains(value);
	}

	@Override
	public void initialize(ValidateGreeting constraintAnnotation) {
		valueList = new ArrayList<String>();
		Class<? extends Enum<?>> enumClass = constraintAnnotation.enumCl();

		@SuppressWarnings("rawtypes")
		Enum[] enumValArr = enumClass.getEnumConstants();

		for (@SuppressWarnings("rawtypes")
		Enum enumVal : enumValArr) {
			valueList.add(enumVal.toString());
		}
		valueList.add(null);
	}

}