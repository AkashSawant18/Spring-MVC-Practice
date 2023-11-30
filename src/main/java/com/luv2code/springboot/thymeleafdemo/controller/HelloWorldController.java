package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

	@GetMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	@RequestMapping("/processForm")
	public String processFrom() {
		return "helloworld";

	}

	@PostMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		// read the request parameter from html form
		String theName = request.getParameter("studentName");

		// convert to upper case
		theName = theName.toUpperCase();

		// create the message
		String result = "yo!" + theName;

		// add message to model
		model.addAttribute("message", result);
		return "helloworld";

	}

	@PostMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {

		// convert to upper case
		theName = theName.toUpperCase();

		// create the message
		String result = "Hey my friend " + theName;

		// add message to model
		model.addAttribute("message", result);
		return "helloworld";

	}

}
