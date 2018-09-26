package com.me.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.me.boot.model.Person;
import com.me.boot.service.IPersonService;

@Controller
@RequestMapping("/")
public class PersonController {
	
	private IPersonService personService;
	
	
	public PersonController(IPersonService personService) {
		super();
		this.personService = personService;
	}

	@GetMapping("/register")
	public String homePage(Model model) {
		model.addAttribute("person", new Person());
		return "home";
	}
	
	@GetMapping
	public String home(Model model) {
		return "redirect:/register";
	}

	@PostMapping("/register")
	public String createPerson(@ModelAttribute("person") Person person,RedirectAttributes attributes) {
		
		personService.savePerson(person);
		attributes.addFlashAttribute("msg", "information saved successfully");
		
		return "redirect:/register";
	}
	
	

}
