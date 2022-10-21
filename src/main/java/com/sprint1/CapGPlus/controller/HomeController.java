package com.sprint1.CapGPlus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(method = RequestMethod.GET, value = "/")
	private String home() {
		return "home.html";
	}
}
