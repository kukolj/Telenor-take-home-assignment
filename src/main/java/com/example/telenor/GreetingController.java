package com.example.telenor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

@Controller
@Validated
@RequestMapping("/greeting")
public class GreetingController {

	enum Account {
		personal, business
	}

	enum Type {
		small, big
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String greeting(
			@RequestParam(name = "id", required = false) @Min(value = 1L, message = "The value of ID must be positive.") Long id,
			@RequestParam(name = "type", required = false) @ValidateGreeting(enumCl = Type.class, message = "Allowed values for type: small, big.") String type,
			@RequestParam(name = "account", required = false) @NotNull @ValidateGreeting(enumCl = Account.class, message = "Allowed values for account: personal, business.") String account) {

		if (id != null && account.equals("personal"))
			return "Hi, userId " + id;
		else if (id == null && account.equals("personal"))
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "ID parameter missing.");

		if (account.equals("business") && type != null) {

			if (type.equals("small"))
				throw new HttpClientErrorException(HttpStatus.NOT_IMPLEMENTED, "Path is not yet implemented.");

			if (type.equals("big"))
				return "Welcome, " + account + " user!";

		} else if (account.equals("business") && type == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "TYPE parameter missing.");
		}

		return "Unexpected error.";

	}
}