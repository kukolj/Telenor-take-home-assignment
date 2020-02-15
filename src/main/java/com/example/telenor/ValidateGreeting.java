package com.example.telenor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ValidateGreetingImp.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateGreeting {

	Class<? extends Enum<?>> enumCl();

	String message() default "Allowed values: personal, business";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
