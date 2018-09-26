package com.me.boot.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class AddressUtil {

	
	public void addUiComponents( Model model) {
		
		
		model.addAttribute("country", new ArrayList<String>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{
			
			add("India");
			add("USA");
			add("Germany");
			add("England");
			add("Russia");
			add("Canada");
			add("Mexico");
			
		}});
		
	}
	
	
}
