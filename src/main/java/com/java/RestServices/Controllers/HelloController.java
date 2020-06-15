package com.java.RestServices.Controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class HelloController {

	
	@Autowired
	MessageSource messageSource;
	
	@GetMapping("/international")
    public String getInternationalPage(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("hello.world", null, LocaleContextHolder.getLocale());
    }
	}

