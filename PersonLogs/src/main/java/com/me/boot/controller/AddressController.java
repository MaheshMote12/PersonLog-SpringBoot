package com.me.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.me.boot.command.AddressCommand;
import com.me.boot.service.IAddressService;
import com.me.boot.service.IPersonService;
import com.me.boot.util.AddressUtil;

@Controller
@RequestMapping("/")
public class AddressController {
	
	private IAddressService addrService;
	private IPersonService personService;
	private AddressUtil addrUtil;

	public AddressController(IAddressService addrService, IPersonService personService, AddressUtil addrUtil) {
		super();
		this.addrService = addrService;
		this.personService = personService;
		this.addrUtil = addrUtil;
	}


	@GetMapping("/person/{pid}/address/new")
	public String addAddress(@PathVariable("pid") Long pid, Model model) {
		
//		Person person = personService.findById(pid);
//		model.addAttribute("person", person);

		AddressCommand addressCommand = new AddressCommand();
		addressCommand.setPid(pid);
		
		
		model.addAttribute("address", addressCommand);
		addrUtil.addUiComponents(model);
		
		return "new_address";
	}
	
	@PostMapping("/person/{pid}/address/new")
	public String createAddress(@ModelAttribute("address") AddressCommand addrCommand,  
			@PathVariable("pid") Long pid, Model model) {
		
		addrService.saveAddress(pid, addrCommand);
		
		return "redirect:/all";
		
	}
		
	

}
