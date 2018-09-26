package com.me.boot.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/all")
	public String allData(@PageableDefault(size=4, page=0) Pageable pageable, Model model) {
		
		model.addAttribute("page", personService.findAll(pageable));
		
		return "person_data";
	}
	
	
	@GetMapping("/update")
	public String updatePerson(@RequestParam("personId")  Long pid, Model model) {
		
		model.addAttribute("person", personService.fingOneById(pid));
		
		return "edit_person";
	}
	
	

}
