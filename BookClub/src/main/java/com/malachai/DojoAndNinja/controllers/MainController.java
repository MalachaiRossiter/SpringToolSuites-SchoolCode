package com.malachai.DojoAndNinja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malachai.DojoAndNinja.models.User;

@Controller
@RequestMapping("/BookClub")
public class MainController {
	
	@GetMapping("/")
	public String reroute() {
		return "redirect:/BookClub/Login";
	}
	
	@GetMapping("/Login")
	public String Login(@ModelAttribute("newUser")User user) {
		return "index.jsp";
	}
}
