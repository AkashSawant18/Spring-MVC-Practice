package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.model.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
	
	@Value("${countries}")
	private List<String> countries;

	@GetMapping("/showStudentForm")
	public String showForm(Model theModel) {

		// create student object
		Student theStudent = new Student();

		// add student object to model
		theModel.addAttribute("student", theStudent);
		
		//add list of countries to the model
		theModel.addAttribute("countries",countries);

		return "student-form";
	}

	@PostMapping("/processStudentForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		// log the input data
		System.out.println("the Student :" + theStudent.getFirstName() + " " + theStudent.getLastName());
		return "student-confirmation";
	}
}
